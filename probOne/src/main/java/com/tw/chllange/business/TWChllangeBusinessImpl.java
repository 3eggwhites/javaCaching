package com.tw.chllange.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.tw.chllange.model.Products;

@Component
public class TWChllangeBusinessImpl implements ITWChllangeBusiness {

	@Override
	public JSONObject getActiveCount(List<Products> productList) {
		JSONObject json = new JSONObject();
		Date todayDate = Calendar.getInstance().getTime();
		// HashMap<String, List<Products>> activeProdMap = new HashMap<>();
		// List<Products> prodList = null;
		// HashMap<String, Integer> countByCat = new HashMap<>();
		int totalCount = 0;
		for (Products prod : productList) {
			if ((null != prod.getStartDate() && todayDate.compareTo(prod.getStartDate()) > 0)
					&& (null == prod.getEndDate() || todayDate.compareTo(prod.getEndDate()) < 0)) {
				//System.out.println(prod);

				totalCount += prod.getPrice();
			}
		}
		try {
			json.put("totalValue", totalCount);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}

}
