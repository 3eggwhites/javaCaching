package com.caching.demo.client;

import org.apache.jcs.JCS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caching.demo.dataLoader.ICountryDataLoader;

@Component
public class CacheClientImpl implements ICacheClient {

	@Autowired
	ICountryDataLoader countryLoader;

	@Override
	public Object getCachedObject(String tableName, Integer id) throws Exception {
		JCS cache = JCS.getInstance(tableName);
		return cache.get(id);
	}

	@Override
	public void removeSingleCachedObject(String tableName, Integer id) throws Exception {
		JCS cache = JCS.getInstance(tableName);
		cache.remove(id);
	}

	@Override
	public void removeSpecificObject(String tableName) throws Exception {
		JCS cache = JCS.getInstance(tableName);
		cache.clear();
	}

	@Override
	public void loadData() throws Exception {
		countryLoader.loadCountryDataInCache();

	}

}
