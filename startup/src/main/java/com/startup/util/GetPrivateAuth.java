package com.startup.util;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.qiniu.util.Auth;

public class GetPrivateAuth {
	
	
	Auth auth = Auth.create("J7V8n9-AT8i66UwfkMc4rM-QckU_MLZzbzSpnhtn", "sfIkWDzmZno7Rlpk0rvAKRuxDjhfc2AZh5eGPNVQ");
	/*static String oldDate = "2015-05-01";
	static String oldDownloadUrl;*/
	//对应七牛云上的空间
	public String privateDownloadUrl(String url) {
		return this.auth.privateDownloadUrl(url, 3600 * 192);
	}
	
	public String uploadToken(String bucket) {
		return this.auth.uploadToken(bucket);
	}
	
	public Auth getAuth() {
		return this.auth;
	}
	
	/*public String privateDownloadUrl(String url, int days) throws ParseException {
		String dateStr = DateUtil.getDateString(new Date());
		if(DateUtil.daysBetween(oldDate, dateStr) >= days) {
			oldDate = dateStr;
			oldDownloadUrl = auth.privateDownloadUrl(url);
		}
		return oldDownloadUrl;
	}*/
}
