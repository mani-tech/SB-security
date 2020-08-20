package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SBIController {
	@GetMapping("/home")
	public String homePage()
	{
		System.out.println("hello home");
		return "home";
	}
	@GetMapping("/loan")
	public String approveLoan()
	{
		return "loan";
	}
	@GetMapping("/balance")
	public String balance()
	{
		System.out.println("hello home");
		return "balance";
	}
	
	@GetMapping("/denied")
	public String accessdenied()
	{
		return "denied";
	}
	@GetMapping("/denied123")
	public String accessdenied123()
	{
		System.out.println("hello home");
		return "denied";
	}
	
}
