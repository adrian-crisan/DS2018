package ro.utcn.sd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@RequestMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@RequestMapping("/viewAll")
	public String viewAll(Model model) {
		
		List<Customer> customers = service.findAll();
		
		model.addAttribute("customers", customers);
		
		return "viewAll";
	}
	
	@RequestMapping("/viewByFirstName")
	public String viewByFirstName(Model model) {
		
		Customer customer = service.findByFirstName("Crisan");
		
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		model.addAttribute("customers", customers);
		
		return "viewByFirstName";
	}
	
	@RequestMapping("/insert")
	public String insert() {
		service.insertCustomer(new Customer("Gog", "Andrei"));
		
		return "insert";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		Customer customer = service.findByFirstName("Gog");
		service.deleteCustomer(customer);
		
		return "delete";
	}
}
