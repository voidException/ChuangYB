package com.startup.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class CacheJobService {
	
	@CacheEvict(value="accountCache", allEntries=true, beforeInvocation=true)
	public void run() {
	}
}
