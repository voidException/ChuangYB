package com.startup.vo;
//为返回某篇文章的一个评论列表，需要接受到的请求
public class CommentsPostVo extends CommonVo {

	private  Integer  articleiD;
    private  Integer  page;
    private  Integer  pageSize;
    
	public Integer getArticleiD() {
		return articleiD;
	}
	public void setArticleiD(Integer articleiD) {
		this.articleiD = articleiD;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
    
}
