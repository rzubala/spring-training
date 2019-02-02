package com.luv2code.springdemo.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.CustomerNotFoundException;
import com.luv2code.springdemo.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(path = "/customers")
	public List<Customer> retrieveCustomers() {
		List<Customer> theCustomers = customerService.getCustomers();
		return theCustomers;
	}

	@DeleteMapping(path = "/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		Customer user = customerService.deleteCustomer(id);
		if (user == null) {
			throw new CustomerNotFoundException("id-"+id);
		}
	}
	
	@PostMapping(path= "/customers")
	public ResponseEntity createCustomer(@Valid @RequestBody Customer user) {
		Customer saved = customerService.saveCustomer(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "/customers/{id}")
	public Resource<Customer> retrieveCustomer(@PathVariable int id) {
		Customer user = customerService.getCustomer(id);
		if (user == null) {
			throw new CustomerNotFoundException("id-"+id);
		}
	
		
		//return user;
		
		//HATEOS
		Resource<Customer> resource = new Resource<Customer>(user);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveCustomers());
		resource.add(linkTo.withRel("all-customers"));
		
		return resource;
	}
}
