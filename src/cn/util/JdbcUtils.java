package cn.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.commons.beanutils.BeanUtils;
/**
 * jdbc工具类
 * @author 彭康
 *
 */
public final class JdbcUtils {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	static {
		try {
			Properties ps = new Properties();
			InputStream instream = JdbcUtils.class.getResourceAsStream("/jdbc.properties");
			ps.load(instream); // 加载属性文件
			driver = ps.getProperty("driver");
			url = ps.getProperty("url");
			user = ps.getProperty("user");
			password = ps.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Class.forName(driver);// 加载驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接对象
	 * 
	 * @return 连接对象
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 查询多个对象
	 * 
	 * @param clazz
	 *            要查询的对象类型
	 * @param sql
	 *            查询语句
	 * @return 查询出的对象组成的集合
	 */
	public static List getList(Class clazz, String sql) {
		List list = new ArrayList();
		Connection conn = getConn();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();// 执行查询
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) { // 遍历查询出的每个结果 并封装对象
				Object obj = clazz.newInstance();
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					BeanUtils.copyProperty(obj, metaData.getColumnName(i), rs.getObject(i));
				}
				list.add(obj); // 将对象添加到集合
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {// 关闭
			close(rs, st, conn);
		}
		return list;
	}
	
	public static ResultSet execute(String sql,Object[] params) throws SQLException{
		Connection conn = getConn();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		preparedStatement = conn.prepareStatement(sql);
		for(int i=0;i<params.length;i++){
			preparedStatement.setObject(i+1, params[i]);
		}
		resultSet = preparedStatement.executeQuery();
		return resultSet;
	}

	/**
	 * 根据标识查询出唯一一个对象
	 * 
	 * @param clazz
	 *            要查询的类型
	 * @param sql
	 *            查询语句
	 * @return 查询出的对象  where id=?
	 */
	public static Object getObjectById(Class clazz, String sql,Object id) {
		Connection conn = getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		Object obj = null;
		try {
			st = conn.prepareStatement(sql);
			st.setObject(1,id);
			rs = st.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			if (rs.next()) { // 如果可以查询出数据
				obj = clazz.newInstance(); // 实例化对象
				for (int i = 1; i <= metaData.getColumnCount(); i++) { // 设置各个列的值到对象  注意：列名和属性名要一致
					BeanUtils.copyProperty(obj, metaData.getColumnName(i), rs.getObject(i));
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			close(rs, st, conn);
		}
		return obj;
	}

	/**
	 * 获取行数
	 * 
	 * @param sql
	 *            查询行数的sql语句
	 * @return 查询的结果
	 */
	public static int getListCount(String sql) {
		int result = 0;
		Connection conn = getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();// 执行查询
			ResultSetMetaData metaData = rs.getMetaData();
			if (rs.next()) {
				result = rs.getInt(1);// 记录查询出的结果
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, st, conn);
		}
		return result;
	}

	/**
	 * 执行增删改的方法
	 * 
	 * @param sql
	 *            增删改的语句
	 * @param ps
	 *            动态数组 语句中的参数
	 * @return 影响的行数
	 */
	public static int executeSQL(String sql, Object... ps) {
		Connection conn = getConn();
		int executeUpdate = 0;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement(sql);
			for (int i = 1; i <= ps.length; i++) {// 设置参数
				prepareStatement.setObject(i, ps[i - 1]);
			}
			executeUpdate = prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, prepareStatement, conn);
		}
		return executeUpdate;
	}

	/**
	 * 事务管理
	 * 
	 * @param sqlArray
	 *            需要在同一个事务中处理的Sql语句
	 */
	public static void executeTran(String... sqlArray) {
		Connection conn = getConn();
		PreparedStatement prepareStatement = null;
		try {
			conn.setAutoCommit(false);// 关闭自动提交
			if (sqlArray.length > 0) {
				for (String sql : sqlArray) {
					prepareStatement = conn.prepareStatement(sql);
					prepareStatement.execute();
				}
			}
			conn.commit();// 所有操作执行结束 提交事务
			conn.setAutoCommit(true);// 打开自动事务提交
		} catch (SQLException e) {// 如果出现异常
			try {
				conn.rollback();// 回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			close(null, prepareStatement, conn);
		}
	}

	/**
	 *关闭资源
	 * @param rs 结果集
	 * @param st 命令行对象
	 * @param conn 数据库连接
	 */
	private static void close(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}		
			if (st != null) {

				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
