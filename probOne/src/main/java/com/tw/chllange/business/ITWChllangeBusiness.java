package com.tw.chllange.business;

import java.util.List;

import org.json.JSONObject;

import com.tw.chllange.model.Products;

public interface ITWChllangeBusiness {
	
	JSONObject getActiveCount(List<Products> productList);
}
