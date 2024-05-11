package com.cts.medicineStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.medicineStore.entity.Medicine;
import com.cts.medicineStore.entity.MyCartList;
import com.cts.medicineStore.service.MedicineService;
import com.cts.medicineStore.service.MyCartListService;

@Controller
public class MedicineController {
	@Autowired
	private MedicineService service;
	
	@Autowired
	private MyCartListService myCartService;
	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/add_medicine")
	public String addMedicine() {
		return "addMedicine";
	}

	@GetMapping("/available_medicine")
	public ModelAndView getAllMedicine() {
		List<Medicine> list =service.getAllMedicine();	
		return new ModelAndView("medicineList","medicine",list);
	}

	@PostMapping("/save")
	public String addMedicine(@ModelAttribute Medicine m) {
		service.save(m);
		return "redirect:/available_medicine";
	}
	
	@GetMapping("/my_cart")
	public String getMyBooks(Model model)
	{
		List<MyCartList> list= myCartService.getAllMyMedicine();
		model.addAttribute("medicine",list);
		double totalPrice=myCartService.getTotalPrice();
		model.addAttribute("totalPrice",totalPrice);
		return "myCart";
	}
	@GetMapping("/mycart/{id}")
	public String getMyCart(@PathVariable("id") int id) {
		Medicine m=service.getMedicineById(id);
		
		MyCartList myCartList=new MyCartList(m.getId(),m.getName(),m.getCompany(),m.getExpirydate(), m.getPrice(),m.getQuantity(),1);
		myCartService.saveMyCart(myCartList);
		return "redirect:/my_cart";
	}
	@GetMapping("/editMedicine/{id}")
	public String editMedicine(@PathVariable("id") int id,Model model) {
		Medicine medicine=service.getMedicineById(id);
		model.addAttribute("medicine",medicine);
		return "editMedicine";
	}
	@GetMapping("/deleteMedicine/{id}")
	public String deleteMedicine(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_medicine";
	}
	
	@GetMapping("/search")
	public ModelAndView searchMedicine(String keyword) {
		List<Medicine> list= service.search(keyword);
		return new ModelAndView("medicineList","medicine",list);
	}
	
}
