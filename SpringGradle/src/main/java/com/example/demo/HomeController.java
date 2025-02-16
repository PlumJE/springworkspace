package com.example.demo;

@Controller
public class HomeController {
	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "Hello, Boot!";
	}
}
