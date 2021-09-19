package com.demo.duan.repository.customer;

import com.demo.duan.entity.CustomerEntity;
import com.demo.duan.service.customer.dto.CustomerDto;
import com.demo.duan.service.customer.param.CustomerParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends JpaRepository<CustomerEntity , Integer> {
    Integer countAllByName(String name);

    @Query("select s from CustomerEntity s where s.role = 1 " +
            "and (:#{#customer.email} is null or s.email = :#{#customer.email})" +
            "and (:#{#customer.password} is null or s.password = :#{#customer.password})" +
            "and (:#{#customer.name} is null or s.name = :#{#customer.name})"+
            "and (:#{#customer.role} is null or s.name = :#{#customer.role})")
            Page<CustomerEntity> search(@Param("customer") CustomerParam customer, Pageable pageable);


}
