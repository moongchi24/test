package com.ch.ch06.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ch.ch06.model.Customer;
import com.ch.ch06.service.CustomerService;
@Controller
// class위에 @RequestMapping는 모든 메서드에 공용
@RequestMapping("/customer/{id}")
// 이 session 컨트롤러에서 editCustomer를 메모리에 저장해서 같이 사용
@SessionAttributes("editCustomer")
public class EditController {
	@Autowired
	private CustomerService cs;
	// /customer/{id}/edit와 같다.
	@RequestMapping("/edit")
	public String edit(@PathVariable int id, Model model) {
		Customer customer = cs.select(id);
		model.addAttribute("editCustomer", customer);
		// redirect 또는 forward를 사용하면 jsp가 아니라 같은 콘트롤러내의 메서드 호출
		return "redirect:enter";
	}
	// /customer/{id}/enter
	// (@ModelAttribute는 객체를 받을 때
	@RequestMapping(value="/enter", method=RequestMethod.GET)
	public String enter(@ModelAttribute("editCustomer") 
				Customer customer) {
		return "/customer/edit/enter";
	}
	// params "event_process" 파라메터(즉 name)이 event_process인 경우 실행
	@RequestMapping(value="/enter", params="event_process")
	public String review(@Valid @ModelAttribute("editCustomer")
			Customer customer, Errors errors) {
		if (errors.hasErrors())
			return "customer/edit/enter";
		else
			return "customer/edit/review";
	}
	@RequestMapping(value="/review", params="event_confirm")
	public String edit(@ModelAttribute("editCustomer") Customer customer,
			SessionStatus ss) {
		cs.update(customer);
		// 메모리에 있는 editCustomer를 삭제
		ss.setComplete();
		// redirect뒤에 /가 있을 경우 root로 시작 즉 /customer/{id}를 생략
		return "redirect:/customer";
	}
	@RequestMapping(value="/review", params="event_cancel")
	public String cancel() {
		// /가 없으르로 ㄸditController내부의 enter
		return "redirect:enter";
	}
}