package com.myapp.rest.webservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.myapp.rest.webservices.domain.SomeBean;

@RestController
public class FilteringController {

	/*
	 * @GetMapping(value = "/filtering") public SomeBean retreivesSomeBean() {
	 * return new SomeBean("value1", "value2", "value3", "value4"); }
	 */

	// Send back field 1 and field 2
	@GetMapping(value = "/filtering")
	public MappingJacksonValue retreivesSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3", "value4");
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		
		mapping.setFilters(filters);

		return mapping;
	}

	// Send back field 3 and field 4
	@GetMapping(value = "/filtering-list")
	// @RequestMapping(method=RequestMethod.GET,value="/")
	public MappingJacksonValue retreivesSomeBeanAsList() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3", "value4"),
				new SomeBean("value12", "value22", "value33", "value44"));
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3", "field4");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		
		mapping.setFilters(filters);
		return mapping;
	}
}
