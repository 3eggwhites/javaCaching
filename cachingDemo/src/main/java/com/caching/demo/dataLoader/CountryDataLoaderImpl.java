package com.caching.demo.dataLoader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;
import org.springframework.stereotype.Component;

import com.caching.demo.entities.Country;

@Component
public class CountryDataLoaderImpl implements ICountryDataLoader {

	private JCS countryCache;

	static List<Country> countryList = new ArrayList<>();

	static {
		Country c1 = new Country(1, "IN", "India", "A", new Date(), 1);
		Country c2 = new Country(2, "UK", "England", "A", new Date(), 1);
		Country c3 = new Country(3, "AU", "Australia", "A", new Date(), 1);
		Country c4 = new Country(4, "JP", "Japan", "A", new Date(), 1);
		Country c5 = new Country(5, "CN", "China", "A", new Date(), 1);
		Country c6 = new Country(6, "USA", "America", "A", new Date(), 1);
		Country c7 = new Country(7, "CAN", "Cnada", "A", new Date(), 1);
		countryList.add(c1);
		countryList.add(c2);
		countryList.add(c3);
		countryList.add(c4);
		countryList.add(c5);
		countryList.add(c6);
		countryList.add(c7);
	}

	@Override
	public void loadCountryDataInCache() throws Exception {
		
		countryCache = JCS.getInstance("REF_COUNTRY");
		countryList.forEach(country -> {
			try {
				countryCache.put(country.getCountryId(), country);
			} catch (CacheException e) {
				e.printStackTrace();
			}
		});
	}

}
