package com.demo.beanstalk.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostHelloController {

	@PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee secondGreet(@RequestBody Employee employee) {
		return employee;
	}

	public static class Employee {

		private String name;
		private int age;

		public Employee(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		public Employee() {

		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

	}

}
