package com.luv2code.springboot.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	@GetMapping("v1/person")
	public PersonV1 personv1()
	{
		return new PersonV1("Jai Shr Ram");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personv2()
	{
		return new PersonV2(new Name("Jai Shri","Ram"));
	}
	@GetMapping(value="/person/param",params="version=2")
	public PersonV2 paramV2()
	{
		return new PersonV2(new Name("Jai Shri","Ram"));
	}
	
	@GetMapping(value="/person/param",params="version=1")
	public PersonV1  paramV1()
	{
		return new PersonV1("Jai Shr Ram");
	}
	@GetMapping(value="/person/header",headers="X-API-version=2")
	public PersonV2 header2()
	{
		return new PersonV2(new Name("Jai Shri","Ram"));
	}
	
	@GetMapping(value="/person/header",headers="X-API-version=1")
	public PersonV1  header1()
	{
		return new PersonV1("Jai Shr Ram");
	}
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v2+json")
	public PersonV2 produces2()
	{
		return new PersonV2(new Name("Jai Shri","Ram"));
	}
	
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public PersonV1  produces1()
	{
		return new PersonV1("Jai Shri Ram");
	}

}
