package com.nemo.sj.miaosha.common.cache;

public interface KeyPrefix {
		
	public int expireSeconds();
	
	public String getPrefix();
	
}
