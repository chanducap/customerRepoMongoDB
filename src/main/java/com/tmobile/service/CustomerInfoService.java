package com.tmobile.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;


import org.springframework.stereotype.Service;

import com.tmobile.repository.CustomerRepositoryDAO;
import com.tmobile.vo.CustomerVO;

@Service
public class CustomerInfoService {
	@Autowired
	private CustomerRepositoryDAO repository;

	@Autowired
	private MongoTemplate template;
	


	public CustomerVO getCustomerInfoByPhoneNumber(String phoneNumber) {

		return repository.findCustomerByPhoneNumber(phoneNumber);
	}

	public CustomerVO saveCustomerInfo(CustomerVO customer) {
		
			try {
				customer = repository.insert(customer);
			} catch (Exception e) {
				e.printStackTrace();
			}

		
		return customer;

	}

	public CustomerVO updateCustomerInfo(CustomerVO customer) {
		try {

			template.save(customer);
		}

		catch (Exception e) {
			System.out.println("msg in catch" + e.getMessage());
		}

		return customer;

		// TODO Auto-generated method stub
	}

}
