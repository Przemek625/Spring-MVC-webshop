package com.packt.webstore.controller;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private CustomerRepository repository;


	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Web Store!");
		model.addAttribute("tagline", "The one and only amazing web store");
		
		return "welcome";
	}

	@RequestMapping("/customers")
	public String showCustomers(Model model){
		model.addAttribute("customers",repository.getAllCustomers());
		return "customers";
	}

	@RequestMapping("/customers/delete/{id}")
	public String deleteCustomer(@PathVariable("id") int id){
		repository.deleteCustomer(id);
		return "redirect:/customers";
	}

	@RequestMapping(value = "/customers/add", method = RequestMethod.GET)
	public String getAddNewCustomerForm(@ModelAttribute("customer") Customer customer) {
		return "add";
	}

	@RequestMapping(value = "/customers/add", method = RequestMethod.POST)
	public String processAddCustomerForm(@ModelAttribute("customer") Customer customer) {

		repository.addCustomer(customer);
		return "redirect:/customers";
	}

	@RequestMapping(value = "customers/update/{id}", method=RequestMethod.GET)
	public String getUpdateCustomer(@ModelAttribute("customer") Customer customer, @PathVariable int id){
		return "update";
	}

	@RequestMapping(value="customers/update/{id}", method=RequestMethod.POST)
	public String processUpdateCustomerForm(@ModelAttribute("customer") Customer customer, @PathVariable int id){
		repository.updateCustomer(customer,id);
		return "redirect:/customers";
	}
}
