package cn.springboot.hrm.entity;

import lombok.ToString;

/**
 * @author zyw
 */
@ToString
public class Page {

	private int currPageNo; //当前页面
	private int pageSize; //每一页显示的数据行数
	private int totalCount; //总记录数
	private int totalPageCount; //总页数
	
	public int getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		//totalPage 总页数
		if(totalCount % pageSize==0){
			//说明整除，正好每页显示pageSize条数据，没有多余一页要显示少于pageSize条数据的
			this.totalPageCount = totalCount / pageSize;
		}else{
			//不整除，就要在加一页，来显示多余的数据。
			this.totalPageCount = totalCount / pageSize +1;
		}
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

}
