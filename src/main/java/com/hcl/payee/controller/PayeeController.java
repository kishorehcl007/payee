package com.hcl.payee.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.payee.entity.Payee;
import com.hcl.payee.service.PayeeService;
import com.hcl.payee.service.PayeeServiceImpl;

@RestController
@RequestMapping("/paypee")
public class PayeeController {
	
	@Autowired
	PayeeService payeeService;
	
	@Autowired
	private PayeeServiceImpl payeeServiceImpl;

	@GetMapping("/welcome")
	public String test() {

		return "welocme";
	}
	
	@GetMapping("/payeedelete/{payeeid}")
	public String payeeDelete(@PathParam(value = "payeeId") int payeeId){
		
		return payeeService.delete(payeeId);
		
	}

	@PostMapping("/addpayee")
	public String addPayee(@RequestBody Payee payee) {

		payeeServiceImpl.addPayee(payee);

		return "successfully added payee";

	}
	
	@PostMapping("/validateotp/{otp}")
	public void validatePayeeOtp(@PathVariable("otp") long otp) {



	}
	
	
	
	
	
	

}
