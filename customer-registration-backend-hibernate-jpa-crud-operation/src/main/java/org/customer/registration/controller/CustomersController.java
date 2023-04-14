package org.customer.registration.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.customer.registration.exception.RecordNotFoundException;
import org.customer.registration.model.Customers;
import org.customer.registration.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backend")
public class CustomersController {
	
	@Autowired
	private CustomersRepository customersRepository;
	
	@GetMapping("/customers")
	public List<Customers> getAllCustomers(){
		return this.customersRepository.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customers> getCustomersById(@PathVariable(value = "id") Long customersId) 
			throws RecordNotFoundException{
		
		Customers customer = customersRepository.findById(customersId)
				.orElseThrow(() -> new RecordNotFoundException("customer not found. id:  "
		+ customersId));
		return ResponseEntity.ok().body(customer);
	}
	
	@PostMapping("/customers")
	public Customers insertCustomer(@RequestBody Customers customer) {
		return this.customersRepository.save(customer);
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customers> updateCustomers(@PathVariable(value = "id") Long customersId,
			@Validated @RequestBody Customers customerInfo) throws RecordNotFoundException{
		Customers customer = customersRepository.findById(customersId)
				.orElseThrow(() -> new RecordNotFoundException("customer not found. id: "
		+ customersId));
		
		customer.setFname(customerInfo.getFname());
		customer.setLname(customerInfo.getLname());
		customer.setAge(customerInfo.getAge());
		customer.setGender(customerInfo.getGender());
		customer.setEmail(customerInfo.getEmail());
		customer.setRegistrationDate(customerInfo.getRegistrationDate());
		
		return ResponseEntity.ok(this.customersRepository.save(customer));
	}
	
	@DeleteMapping("/customers/{id}")
	public Map<String, Boolean> deleteCustomerById(@PathVariable(value = "id") Long customersId) 
			throws RecordNotFoundException{
		Customers customer = customersRepository.findById(customersId)
				.orElseThrow(() -> new RecordNotFoundException("customer not found. id: "
		+ customersId));
		
		this.customersRepository.delete(customer);
		
		Map<String, Boolean> result = new HashMap<>();
		result.put("Customer's info successfully deleted", Boolean.TRUE);
		
		return result;
	}
}