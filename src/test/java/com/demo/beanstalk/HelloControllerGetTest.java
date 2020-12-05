package com.demo.beanstalk;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.beanstalk.Resource.HelloController;
import com.demo.beanstalk.Services.HelloService;

@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@WebMvcTest(HelloController.class)
public class HelloControllerGetTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	HelloService helloService;
	
	@Test
	public void firstGreet() throws Exception {
		when(helloService.firstGreet()).thenReturn("Hello Aravind");
		
		this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello Aravind")));

	}
}
