package cn.service;

public abstract class AbstractState {
	protected ForumAccount acc;
	protected int point;
	protected String stateName;
	public abstract void checkState(int score);
	
	public void writeSellNote(int score)
	{
		System.out.println(acc.getUname()+"发布出售信息，增加"+score+"积分。");
		this.point += score;
		acc.setUclass(point);
		acc.updateuser();
		checkState(score);
		System.out.println("当前积分为："+this.point+",当前级别为："+this.stateName);
	}
	
	public void writeBuyNote(int score)
	{
		System.out.println(acc.getUname()+"发布求购信息，增加"+score+"积分。");
		this.point += score;
		acc.setUclass(point);
		acc.updateuser();
		checkState(score);
		System.out.println("当前积分为："+this.point+",当前级别为："+this.stateName);
	}
	
	public void comment(int score)
	{
		System.out.println(acc.getUname()+"添加评论，增加"+score+"积分。");
		this.point += score;
		acc.setUclass(point);
		acc.updateuser();
		checkState(score);
		System.out.println("当前积分为："+this.point+",当前级别为："+this.stateName);		
	}
	
	public void setPoint(int point)
	{
		this.point = point;
	}
	
	public int getPoint()
	{
		return(this.point);
	}
	
	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}
	
	public String getStateName()
	{
		return(this.stateName);
	}

}
