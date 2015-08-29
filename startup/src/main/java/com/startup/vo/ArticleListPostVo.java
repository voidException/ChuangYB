package com.startup.vo;
/*这个是前端用来发送请求文章列表数据的*/
public class ArticleListPostVo extends CommonVo {
         Integer  tag;
         Integer  page;
         Integer  pageSize;
		public Integer getTag() {
			return tag;
		}
		public void setTag(Integer tag) {
			this.tag = tag;
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
