package com.caching.demo.tester;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.caching.demo.client.ICacheClient;
import com.caching.demo.entities.Country;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CachingDemoTest {
	@Autowired
	ICacheClient client;
	
	@Test
	public void checkCache() throws Exception {
		client.loadData();
		Country c = (Country) client.getCachedObject("REF_COUNTRY", 1);
		System.out.println(c.toString());
	}

}
