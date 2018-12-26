package cn.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.dao.BtypeDao;
import cn.util.JdbcUtils;

public class BtypeImpl implements BtypeDao {

	@Override
	public Integer getTypeID(String type) throws SQLException{
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		Integer btid = null;
		String sql = "select * from btype where btname = ?";
		Object[] params = {type};
		resultSet = JdbcUtils.execute(sql, params);
		while(resultSet.next()){
			btid = resultSet.getInt("btid");
		}
		return btid;
	}

	@Override
	public String getTypeBytid(Integer tid) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		String btype = null;
		String sql = "select * from btype where btid = ?";
		Object[] params = {tid};
		resultSet = JdbcUtils.execute(sql, params);
		while(resultSet.next()){
			btype=resultSet.getString("btname");
		}
		return btype;
	}
}
