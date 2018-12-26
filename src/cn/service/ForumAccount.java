package cn.service;

import cn.daoimpl.UserDaoImpl;
import cn.entity.*;

public class ForumAccount {
	private AbstractState state;
	private User user;
	private UserDaoImpl userDaoImpl;
	public ForumAccount(User user)
	{
		this.user = user;
		this.userDaoImpl = new UserDaoImpl();
		this.state = new PrimaryState(this);
	}
	public int getUclass()
	{
		return user.getUclass();
	}
	
	public void setUclass(int point)
	{
		user.setUclass(point);
	}
	
	public void setState(AbstractState state)
	{
		this.state = state;
	}
	
	public AbstractState getState()
	{
		return this.state;
	}
	
	public String getUname()
	{
		return this.user.getUname();
	}
	
	public void writeSellNote(int score)
	{
		state.writeSellNote(score);
	}
	
	public void writeBuyNote(int score)
	{
		state.writeBuyNote(score);
	}
	
	public void comment(int score)
	{
		state.comment(score);
	}
	
	public void updateuser()
	{
		userDaoImpl.modifyUserClass(user);
	}
	
}
