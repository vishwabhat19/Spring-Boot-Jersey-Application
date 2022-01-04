package com.springjersey.api;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springjersey.api.dao.EmployeeDAO;
import com.springjersey.api.model.Employee;

@SpringBootApplication
public class SpringbootJerseyProjectApplication {
	
	@Autowired
	private EmployeeDAO dao;
	
	@PostConstruct
	public void initDB() {
		dao.saveAll(Stream.of(new Employee(1,"Vishwa","DC"), new Employee(2, "Kavita", "ADC")).collect(Collectors.toList()));
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJerseyProjectApplication.class, args);
	}

}
