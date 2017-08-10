package com.tw.chllange.service;

import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tw.chllange.business.ITWChllangeBusiness;
import com.tw.chllange.model.Products;
import com.tw.chllange.util.IConstants;

@RestController
@RequestMapping("/")
public class TWChllangeProducerServiceImpl implements ITWChllangeProducerService {
	
	@Autowired
	ITWChllangeBusiness business;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	@RequestMapping(value = "/count", method = RequestMethod.POST)
	public HttpStatus postProductsCount() {
		Products[] prodArray = null;
		List<Products> prodList = null;
		JSONObject json = null;
		//RestTemplate restTemplate = new RestTemplate();
		StringBuilder uriBuilder = new StringBuilder(IConstants.baseUri);
		uriBuilder.append("input");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add(IConstants.headerKey, IConstants.headerVal);
		HttpEntity<Products[]> entityProd = new HttpEntity<Products[]>(prodArray, headers);
		ResponseEntity<Products[]> response = restTemplate.exchange(uriBuilder.toString(), HttpMethod.GET, entityProd,
				Products[].class);
		
		prodArray = response.getBody();
		
		if(null!=prodArray) {
			prodList = Arrays.asList(prodArray);
			json = business.getActiveCount(prodList);
		}/*else {
			countObj.setCount(0);
		}*/
		
		uriBuilder = new StringBuilder(IConstants.baseUri);
		uriBuilder.append("output");
		
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add(IConstants.headerKey, IConstants.headerVal);
		
		HttpEntity<String> entityCount = new HttpEntity<String>(json.toString(), headers);
		
		ResponseEntity<?> responseCnt = restTemplate.exchange(uriBuilder.toString(), HttpMethod.POST, entityCount,
				String.class);
		System.out.println(json.toString()+" status "+responseCnt.getStatusCode());
		//System.out.println(json.toString());
		return HttpStatus.OK;
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder.build();
	}

}
