package com.ashspell.memo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller	
public class HelloWorld {
	
	@GetMapping("/hello")
	@ResponseBody
	public String helloworld() {
		return "Hello world!";
	}
}
