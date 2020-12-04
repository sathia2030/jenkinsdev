package com.demo.beanstalk.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beanstalk.Services.HelloService;

@RestController
public class HelloController {

	@Autowired
	HelloService helloService;

	@GetMapping(value = "/hello")
	public String firstGreet() {
		return "Good Morning " + helloService.firstGreet();
	}


}
