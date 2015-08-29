package com.startup.util;

import org.springframework.cache.annotation.CacheEvict;

public class DeleteCache {
	
	@CacheEvict(value="accountCache",allEntries=true)// 清空 accountCache 缓存
	public static void reload() { 
	} 
}
