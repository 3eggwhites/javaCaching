package com.caching.demo.client;

public interface ICacheClient {

	public Object getCachedObject(String tableName, Integer id) throws Exception;

	public void removeSingleCachedObject(String tableName, Integer id) throws Exception;

	public void removeSpecificObject(String tableName) throws Exception;
	
	void loadData() throws Exception;

}
