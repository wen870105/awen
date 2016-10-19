package com.wen.util;

/**
 * 
 * @Author: Wen
 * @CreatDate: 2015年9月28日
 * @Version:
 */
public class QueryCondition {
	// 第几页
	private int currPage = 1;
	// 每页数量
	private int perItems = 10;
	//分页标志
	private String limit;
	// 查询分页参数
	private int start;
	private int offset;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	
	public int getCurrPage() {
		return currPage<0 ? 1 : currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPerItems() {
		return perItems;
	}

	public void setPerItems(int pPerItems) {
		perItems = pPerItems;
	}

	public void initPagination() {
		setPerItems(perItems);
		// 页面最小值为1
		int pIndex = getCurrPage();
		int items = getPerItems();
		if (pIndex > 0) {
			setStart((pIndex - 1) * items);
		} else {
			setStart(0);
		}
		setOffset(getPerItems());
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}
}
