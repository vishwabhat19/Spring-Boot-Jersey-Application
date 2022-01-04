package com.springjersey.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjersey.api.model.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
	
	Employee findByName(String name);
	
	List<Employee> findByIdBetween(Integer startId, Integer endId);

}
