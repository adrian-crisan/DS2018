package ro.utcn.sd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	public List<Customer> findAll() {
		return repository.findAll();
	}
	
	public Customer findByFirstName(String firstName) {
		return repository.findByFirstName(firstName);
	}
	
	public void insertCustomer(Customer customer) {
		repository.save(customer);
	}
	
	public void deleteCustomer(Customer customer) {
		repository.delete(customer);
	}
}
