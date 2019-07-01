package com.eksad.letihanjpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eksad.letihanjpa.dao.EmployeeDAO;
import com.eksad.letihanjpa.model.Employee;



@Configuration
public class Action {

	@Autowired
	EmployeeDAO employeeDAO;
	
	//@Bean
	public List<Employee> getAll(){
		List<Employee> employees = employeeDAO.getAll();
	/*	
		for (Employee employee : employees) {
			System.out.println("ID :" + employee.getId());
			System.out.println("Name :" + employee.getNama());
			System.out.println("Address :" + employee.getAddress());
			System.out.println("DOB :" + employee.getDob());
			System.out.println("====================================");
		}
	*/
		return employees;
	}
	//@Bean
	public Employee getById() {
		Employee employee = employeeDAO.getById(10);
	/*	
		System.out.println("GET BY ID =10");
		System.out.println("ID :" + employee.getId());
		System.out.println("Name :" + employee.getNama());
		System.out.println("Address :" + employee.getAddress());
		System.out.println("DOB :" + employee.getDob());
		System.out.println("====================================");
	*/
		return employee;
	}
	//@Bean
	public boolean save() {
		try {
			Employee employee = new Employee();
			
			employee.setNama("Kamu");
			employee.setAddress("DIHATIMU");
			
			String dateString ="2019-07-01";
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			employee.setDob(date);
			employeeDAO.save(employee);
			System.out.println("Data Berhasil Disimpan");
			
			return true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//@Bean
	public boolean update() {
		try {
			Employee employee = new Employee();
			
			employee.setId(5);
			employee.setNama("Aku");
			employee.setAddress("DIHATIKU");
			
			String dateString ="2019-07-02";
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			
			employee.setDob(date);
			
			employeeDAO.update(employee);
			System.out.println("Data Berhasil Disimpan");
			
			return true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//@Bean
	public boolean delete() {
		try {
			employeeDAO.delete(5);
			System.out.println("Data Berhasil Dihapus");
			return true;
		} catch (Exception e) {
			System.out.println("Data Gagal dihapus");
			e.printStackTrace();
			return false;
		}
	}
	
	@Bean
	public List <Employee> getByName(){
		List<Employee> employees = employeeDAO.getByName("Parno");
		

		for (Employee employee : employees) {
			System.out.println("ID :" + employee.getId());
			System.out.println("Name :" + employee.getNama());
			System.out.println("Address :" + employee.getAddress());
			System.out.println("DOB :" + employee.getDob());
			System.out.println("====================================");
		}
	
		return employees;
	}
}
