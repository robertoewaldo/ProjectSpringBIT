package com.bit.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.spring.project.entity.Purchase;
import com.bit.spring.project.repository.PurchaseRepo;

@Controller
public class PurchaseController {
	
	@Autowired
	PurchaseRepo repo;
	
	@GetMapping("/pembelian")
	public String purchase() {
		return "purchase/pembelian";
	}
	
	@PostMapping("/pembelian/confirmation")
	public ModelAndView purchaseConfirmation(Purchase purchase){
		System.out.println("pembelian confirmation");
		;
		ModelAndView mv = new ModelAndView();
		mv.addObject("purchase", purchase);
		mv.setViewName("purchase/pembelian_confirmation");
		return mv;
	}
	
	@PostMapping("/pembelian/confirmed")
	public ModelAndView purchaseConfirmed(Purchase purchase){
		System.out.println("pembelian confirmed");
		repo.save(purchase);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", "success");
		mv.setViewName("success");
		return mv;
	}
}
