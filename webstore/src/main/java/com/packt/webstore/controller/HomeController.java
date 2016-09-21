package com.packt.webstore.controller;

import com.packt.webstore.domain.User;
import com.packt.webstore.domain.repository.CommentRepository;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.domain.repository.UserRepository;
import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.format.annotation.DateTimeFormat;
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
import java.time.LocalDate;

@Controller
public class HomeController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private ProductRepository productRepository;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate localDate;

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Web Store!");
		model.addAttribute("tagline", "The one and only amazing web store");

		return "welcome";
	}

	@RequestMapping("/customers")
	public String showCustomers(Model model){
		model.addAttribute("customers",customerRepository.getAllCustomers());
		return "customers";
	}

	@RequestMapping("/customers/delete/{id}")
	public String deleteCustomer(@PathVariable("id") int id){
		customerRepository.deleteCustomer(id);
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

		if(result.hasErrors()){
			return "add";
		}
		else {
			int rowAffected = customerRepository.addCustomer(customer);
			if (customerImage!=null && !customerImage.isEmpty() && customerImage.getContentType()=="image/jpeg") {
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
		customerRepository.updateCustomer(customer,id);
		return "redirect:/customers";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerPage(@ModelAttribute("user") User user){return "register";}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegisterUser(@ModelAttribute("user") User user, BindingResult result, Model model){

		try {
			userRepository.addUser(user);
		} catch (DuplicateKeyException e) {

			model.addAttribute("usernameExist","User with this username already exists. Choose another username.");
			return "register";
		}

		return "redirect:/login";
	}

	@RequestMapping(value="customers/details/{id}", method = RequestMethod.GET)
	public String showCustomerComments(@ModelAttribute("commentContent") String commentContent, @PathVariable int id, Model model){


		if(customerRepository.customerExists(id)) {
			model.addAttribute("comment", commentRepository.getAllComments(id));
		}
		else throw new CustomerNotFoundException();

		return "details";
	}

	@RequestMapping(value ="customers/details/{id}", method = RequestMethod.POST)
	public String processAddCustomerComment(@ModelAttribute("commentContent") String commentContent, @PathVariable int id){

		commentRepository.
				addComment(commentContent, localDate.now().toString(), id);

		return "redirect:/customers/details/{id}";
	}
	
}
