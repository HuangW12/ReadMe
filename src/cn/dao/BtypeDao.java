package cn.dao;
import java.sql.SQLException;

public interface BtypeDao  {
	public Integer getTypeID(String type)throws SQLException;
	public String getTypeBytid(Integer tid)throws SQLException;
}
