package cn.service;

public class MiddleState extends AbstractState{
	public MiddleState(AbstractState state)
	{
		this.acc = state.acc;
		this.point = state.point;
		this.stateName = "高手";
	}
	
	public void writeSellNote(int score)
	{
		System.out.println(acc.getUname()+"发布出售信息，增加"+score+"*2个积分。");
		this.point += score*2;
		acc.setUclass(point);
		acc.updateuser();
		checkState(score);
		System.out.println("当前积分为："+this.point+",当前级别为："+this.stateName);
	}
	
	public void writeBuyNote(int score)
	{
		System.out.println(acc.getUname()+"发布求购信息，增加"+score+"*2积分。");
		this.point += score*2;
		acc.setUclass(point);
		acc.updateuser();
		checkState(score);
		System.out.println("当前积分为："+this.point+",当前级别为："+this.stateName);
	}
	
	public void comment(int score)
	{
		System.out.println(acc.getUname()+"添加评论，增加"+score+"*2积分。");
		this.point += score*2;
		acc.setUclass(point);
		acc.updateuser();
		checkState(score);
		System.out.println("当前积分为："+this.point+",当前级别为："+this.stateName);		
	}
	
	public void checkState(int score)
	{
		if(point>1000)
		{
			acc.setState(new HighState(this));
		}
		else if(point<=100)
		{
			acc.setState(new PrimaryState(this));
		}
	}
}
