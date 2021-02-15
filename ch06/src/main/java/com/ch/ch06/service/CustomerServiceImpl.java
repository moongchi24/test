package com.ch.ch06.service;
import java.util.HashMap;
import java.util.Collection;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.ch.ch06.model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService{
	private Map<Integer, Customer> map = 
			new HashMap<Integer, Customer>();
	private int nextId; // default 0
	@PostConstruct
	public void init() {
		register(new Customer("승희","마포","k1@k.com"));
		register(new Customer("효리","제주도","k2@k.com"));
		register(new Customer("비룡","논현","k3@k.com"));
		register(new Customer("영웅","강남","k4@k.com"));
	}
	private void register(Customer customer) {
		customer.setId(++nextId);
		map.put(customer.getId(), customer);
	}
	public Collection<Customer> list() {
		return map.values();
	}
	public Customer select(int id) {
		return map.get(id);
	}
	public void delete(int id) {
		map.remove(id);		
	}
	@Override
	public void update(Customer customer) {
		map.put(customer.getId(), customer);
		
	}
}