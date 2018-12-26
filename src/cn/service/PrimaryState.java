package cn.service;

public class PrimaryState extends AbstractState
{
	public PrimaryState(AbstractState state)
	{
		this.acc = state.acc;
		this.point = state.point;
		this.stateName = "新手";
	}
	public PrimaryState(ForumAccount acc)
	{
		this.point = acc.getUclass();
		this.acc = acc;
		this.stateName = "新手";
	}
	
	public void checkState(int score)
	{
		if(point>1000)
		{
			acc.setState(new HighState(this));
		}
		else if(point>=100)
		{
			acc.setState(new MiddleState(this));
		}
	}
}
