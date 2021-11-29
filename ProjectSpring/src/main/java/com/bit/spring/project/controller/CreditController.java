package com.bit.spring.project.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.spring.project.entity.Bill;
import com.bit.spring.project.entity.Transaction;
import com.bit.spring.project.repository.BillRepo;
import com.bit.spring.project.repository.TransactionRepo;

@Controller
public class CreditController {
	
	@Autowired
	TransactionRepo t_repo;
	@Autowired
	BillRepo b_repo;
	
	@GetMapping("/transaksi")
	public ModelAndView transactionPage() {
		
		ModelAndView mv = new ModelAndView();
		
		LocalDate set_date = LocalDate.now();
		mv.addObject("month", set_date.getMonth());
		
		List<Transaction> t_list = t_repo.findAllTransactionThisMonth();
		mv.addObject("transaction_list", t_list);
		
		mv.setViewName("credit/transaksi");
		return mv;
	}
	
	@GetMapping("/tagihan")
	public ModelAndView billPage() {
		
		ModelAndView mv = new ModelAndView();
		
		LocalDate set_date = LocalDate.now().plusMonths(-1);
		mv.addObject("month", set_date.getMonth());
		
		Bill bill = b_repo.findLastMonthBill();
		mv.addObject("bill", bill);
		mv.addObject("paid_amount", bill.getBill_amount() - bill.getRemaining_amount());
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
	    String due_date_str = formatter.format(bill.getDue_date());
	    mv.addObject("due_date_str", due_date_str);
		
		List<Transaction> t_list = t_repo.findAllTransactionLastMonth();
		mv.addObject("transaction_list", t_list);
		
		mv.setViewName("credit/tagihan");
		return mv;
	}
	
	@PostMapping("/tagihan/bayar")
	public String billPay(@RequestParam("bill_id") int bill_id, @RequestParam("pay_amount") int pay_amount) {
		
		Bill bill = b_repo.getById(bill_id);
		int remaining_amount = bill.getRemaining_amount();
		remaining_amount -= pay_amount;
		bill.setRemaining_amount(remaining_amount);
		b_repo.save(bill);
		
		return "success";
	}
}
