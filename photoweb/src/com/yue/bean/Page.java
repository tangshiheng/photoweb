package com.yue.bean;

import java.util.List;

public class Page<T>{
	public static final Integer PAGE_SIZE=3;//设置每页的记录数
	private Integer pageNo;//当前页数
	private Integer pageTotal;//总的页数
	private Integer totalCount;//总的记录数
	private Integer pageSize=PAGE_SIZE;//每页的记录数
	private List<T> items;//存储每页的数据
	
	public Page() {
		super();
	}
	public Page(Integer pageNo, Integer pageTotal, Integer totalCount,
			Integer pageSize, List<T> items) {
		super();
		this.pageNo = pageNo;
		this.pageTotal = pageTotal;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.items = items;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		if(pageNo<0) {
			pageNo=1;
		}else if(pageNo>pageTotal) {
			pageNo=getPageTotal();
		}else {
			this.pageNo = pageNo;
		}
	}
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageTotal=" + pageTotal
				+ ", totalCount=" + totalCount + ", pageSize=" + pageSize
				+ ", items=" + items + "]";
	}
}
