package com.praveenmitian.urlshortner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class process the request based on the query.
 * 
 * @author Wilfred Bett
 *
 */
@RestController
@RequestMapping("/api/v1")
public class UrlController {

	@Autowired
	UrlJDBC urlJDBC;

	/**
	 * Controller process the request and post method used to give the short url
	 * for given long url.
	 * 
	 * @param url
	 * @return Url
	 */
	@RequestMapping(value = "/shorten", method = RequestMethod.POST)
	public Url shortenUrl(@RequestBody Url url) {
		long id = new Date().getTime();
		String encodedId = UrlShortner.encode(id);
		urlJDBC.create(url.getLongUrl(), encodedId);
		return new Url(encodedId, url.getLongUrl());
	}

	
	

	
	
}
