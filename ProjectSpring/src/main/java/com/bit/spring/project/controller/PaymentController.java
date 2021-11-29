package com.bit.spring.project.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.spring.project.entity.Bill;
import com.bit.spring.project.entity.Payment;
import com.bit.spring.project.entity.Transaction;
import com.bit.spring.project.repository.BillRepo;
import com.bit.spring.project.repository.PaymentRepo;
import com.bit.spring.project.repository.TransactionRepo;

@Controller
public class PaymentController {
	
	@Autowired
	PaymentRepo p_repo;
	@Autowired
	TransactionRepo t_repo;
	@Autowired
	BillRepo b_repo;
	
	
	@GetMapping("/pembayaran")
	public String payment() {
		return "payment/pembayaran";
	}
	
	@PostMapping("/pembayaran/confirmation")
	public ModelAndView paymentConfirmation(Payment payment){
		System.out.println("pembayaran confirmation");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("payment", payment);
		mv.setViewName("payment/pembayaran_confirmation");
		return mv;
	}
	
	@PostMapping("/pembayaran/confirmed")
	@Transactional(rollbackOn = SQLException.class)
	public ModelAndView paymentConfirmed(Payment payment) throws SQLException{
		System.out.println("pembayaran confirmed");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		
		p_repo.save(payment);
		
		Bill bill = b_repo.findThisMonthBill();
		
		Transaction transaction = new Transaction();
		transaction.setBill_id(bill.getId());
		transaction.setMerchant("Bayar Telepon");
		transaction.setAmount(payment.getAmount());
		transaction.setTransaction_date(new Date());
		t_repo.save(transaction);
		
		int currentAmount = bill.getBill_amount();
		int remainingAmount = bill.getRemaining_amount();
		bill.setBill_amount(currentAmount += payment.getAmount());
		bill.setRemaining_amount(remainingAmount += payment.getAmount());
		b_repo.save(bill);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", "success");
		mv.setViewName("success");
		return mv;
	}
}
