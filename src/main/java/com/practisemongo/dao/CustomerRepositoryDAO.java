package com.practisemongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practisemongo.vo.CustomerVO;

@Repository
public interface CustomerRepositoryDAO extends MongoRepository<CustomerVO, String> {

	@Query("{'phoneNumber':?0}")
	public CustomerVO findCustomerByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}
