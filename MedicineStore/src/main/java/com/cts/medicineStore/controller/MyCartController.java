package com.cts.medicineStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.medicineStore.entity.MyCartList;
import com.cts.medicineStore.service.MyCartListService;

@Controller
public class MyCartController {
	@Autowired
	private MyCartListService service;
	@PostMapping("/saveCount")
	public String addMedicine(@ModelAttribute MyCartList m) {
		service.saveMyCart(m);
		return "redirect:/my_cart";
	}
	
	@GetMapping("/deleteMyCart/{id}")
	public String deleteMyCart(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/my_cart";
	}
	@GetMapping("/editCount/{id}")
	public String editMedicine(@PathVariable("id") int id,Model model) {
		MyCartList medicine=service.getMedicineById(id);
		model.addAttribute("medicine",medicine);
		return "editCount";
	}
	@GetMapping("/buy")
	public String buyMedicine() {
		service.removeMedicine();
		return "redirect:/my_cart";
	}
}
