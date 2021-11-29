package com.bit.spring.project.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.spring.project.entity.User;
import com.bit.spring.project.repository.UserRepo;

@Controller
public class AdminController {
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/password")
	public String passwordPage() {
		return "admin/password";
	}
	
	@PostMapping("/password/change")
	public ModelAndView passwordChange(Authentication auth, @RequestParam("old_password") String old_password, @RequestParam("new_password") String new_password) {
		
		ModelAndView mv = new ModelAndView();
		String username = auth.getName();
		User user = repo.getById(username);
		
		if(BCrypt.checkpw(old_password, user.getPassword())) {
			user.setPassword(passwordEncoder.encode(new_password));
			repo.save(user);
			mv.setViewName("success");
		}else {
			mv.addObject("error_msg", "Password Lama salah!");
			mv.setViewName("admin/password");
		}
		
		return mv;
	}
	
	@GetMapping("language")
	public String languagePage(HttpServletRequest req) {
		Locale currentLocale = req.getLocale();
		String countryCode = currentLocale.getCountry();
		String countryName = currentLocale.getDisplayCountry();
		String languageCode = currentLocale.getLanguage();
		String languageName = currentLocale.getDisplayLanguage();
		
		System.out.println(countryCode + " : " + countryName);
		System.out.println(languageCode + " : " + languageName);
		System.out.println("===========");
		String[] languages = Locale.getISOLanguages();
		for(String language : languages) {
			Locale locale = new Locale(language);
			System.out.println(language + " : " + locale.getDisplayLanguage());
		}
		
		return "success";
	}
}
