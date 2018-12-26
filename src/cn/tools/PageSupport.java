package cn.tools;
//分页工具类
public class PageSupport {
	private int pageSize = 0;	//每页显示数量
	private int totalPageCount = 1;	//总页数
	private int recCount = 0;	//记录总数
	private int currPageNo = 1;		//当前页码
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize>0){
			this.pageSize = pageSize;
		}
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
			this.totalPageCount = totalPageCount;
	}
	public int getRecCount() {
		return recCount;
	}
	public void setRecCount(int recCount) {
		if(recCount>0){
		this.recCount = recCount;
		this.totalPageCount = (recCount % this.pageSize==0)?(recCount/this.pageSize):(recCount/this.pageSize)+1;
		}
	}
	public int getCurrPageNo() {
		if(this.totalPageCount == 0){
			return 0 ;
		}else{
			return currPageNo;
		}
	}
	public void setCurrPageNo(int currPageNo) {
		if(this.currPageNo>0){
			this.currPageNo = currPageNo;
		}
	}
	
	
}
