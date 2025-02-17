package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller	// Bean등록, Web과 관련된 부분, 파라미터를 자동으로 수집
public class URLController {
	@GetMapping("/urltest")
	@ResponseBody
	public String urlGetTest(String keyword) {
		return "Server Response : Get Method\n Select - " + keyword;
	}
	
	@PostMapping("/urltest")
	@ResponseBody
	public String urlPostTest(String keyword) {
		return "Server Response : Post Method\n Post - " + keyword;
	}
}
