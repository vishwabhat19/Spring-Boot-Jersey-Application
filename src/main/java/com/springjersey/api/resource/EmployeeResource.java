package com.springjersey.api.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.springjersey.api.dao.EmployeeDAO;
import com.springjersey.api.model.Employee;

@Path("/employeeResource")
public class EmployeeResource {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/save")
	public Employee saveEmployee(Employee employee) {
		return employeeDAO.save(employee);
	}
	
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/getAllEmployees")
	public List<Employee> getAllEmployee() {
		return employeeDAO.findAll();
	}
	
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/getEmployeeByName/{name}")
	public Employee getEmployeeByName(@PathParam("name") String name) {
		return employeeDAO.findByName(name);
	}
	
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/getEmployeeBetweenIds")
	public List<Employee> getEmployeeBetweenIds(@QueryParam("startId") Integer startId, @QueryParam("endId") Integer endId) {
		System.out.println("Start Id is: "+startId+" and end Id is: "+endId);
		return employeeDAO.findByIdBetween(startId,endId);
	}
}
