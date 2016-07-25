package com.packt.webstore.controller;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;

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
	public String processAddCustomerForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, HttpServletRequest request) {

		MultipartFile customerImage = customer.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		System.out.println(rootDirectory);

		if(result.hasErrors()){
			return "add";
		}
		else {
			int rowAffected = repository.addCustomer(customer);
			if (customerImage!=null && !customerImage.isEmpty()) {
				try {
					customerImage.transferTo(new File(rootDirectory+"resources\\images\\"+rowAffected + ".jpg"));
					System.out.println("success");
				} catch (Exception e) {
					throw new RuntimeException("Product Image saving failed", e);
				}
			}
			return "redirect:/customers";
		}
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
