package com.myapp.rest.webservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.rest.webservices.domain.Name;
import com.myapp.rest.webservices.domain.PersonV1;
import com.myapp.rest.webservices.domain.PersonV2;

@RestController
public class PersonVersioningController {

	/**
	 * Doing normal uri versioning
	 * 
	 * @return
	 */
	@GetMapping(value = "/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Sumit");
	}

	@GetMapping(value = "/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Sumit", "Das"));
	}

	/**
	 * Doing Param versioning
	 * 
	 * @return
	 */
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Sumit");
	}

	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Sumit", "Das"));
	}

	/**
	 * Doing header versioning
	 * 
	 * @return Person
	 */
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Sumit");
	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Sumit", "Das"));
	}

	/**
	 * Doing produces versioning
	 * 
	 * @return Person
	 */
	@GetMapping(value = "/person/produces", produces = "application/app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Sumit");
	}

	@GetMapping(value = "/person/produces", produces = "application/app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Sumit", "Das"));
	}
}
