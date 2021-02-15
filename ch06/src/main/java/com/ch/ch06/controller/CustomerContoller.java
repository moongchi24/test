package com.ch.ch06.controller;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.ch06.model.Customer;
import com.ch.ch06.service.CustomerService;
@Controller
public class CustomerContoller {
	@Autowired
	private CustomerService cs;
	@RequestMapping("/")
	public String init() {
		// forward, redirect르 사용하면 jsp로 가지 않고 controller내부에 
		// 다른 메서드를 실행 시킨다
		return "forward:/customer";
	}
	@RequestMapping("/customer")
	public String list(Model model) {
		Collection<Customer> list = cs.list();
		model.addAttribute("list", list);
		return "/customer/list";
	}
	@RequestMapping("/customer/{id}")
	public String detail(@PathVariable int id, Model model) {
		Customer customer = cs.select(id);
		model.addAttribute("customer", customer);
		return "/customer/detail";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		cs.delete(id);
		return "/customer/delete";
	}
}