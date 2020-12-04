package com.demo.beanstalk;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.beanstalk.Resource.PostHelloController;

@WebMvcTest(PostHelloController.class)
public class HelloControllerPostTest {

	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	public void secondGreet() throws Exception {

		String json = "{\"name\":\"Aravind\", \"age\":10}";

		this.mockMvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.name", Matchers.is("aravinda")))
				.andExpect(jsonPath("$.age", Matchers.is(10))).andExpect(jsonPath("$.*", Matchers.hasSize(2)));
	}

}
