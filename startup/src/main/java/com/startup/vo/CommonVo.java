package com.startup.vo;

public class CommonVo {   //一旦登录进去，就可以
	private String token;//这个是根据用户邮箱和随机生成的一段字符串组合成的，但现在就只是邮箱
	private Integer iD;  //这个是用户的自增长iD，后续操作传输这个会带来方便的，先加上
	
	public String getToken(){
		return token;
	}
	public void setToken(String token){
		this.token=token;
	}
	public Integer getiD() {
		return iD;
	}
	public void setiD(Integer iD) {
		this.iD = iD;
	}
	
}
