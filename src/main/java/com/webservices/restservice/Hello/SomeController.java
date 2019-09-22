package com.webservices.restservice.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {
	
	@GetMapping("/hello")
	public String myfunction()
	{
		return "hello";
	} 
	
	@GetMapping("/hellobean")
	public HelloBean helloBean()
	{
		return new HelloBean("hellobean");
	}
	
	@GetMapping("/hellobean/path-variable/{name}")
	public HelloBean helloBean(@PathVariable String name)
	{
		return new HelloBean(String.format("hellobean, %s",name));
	}

}
