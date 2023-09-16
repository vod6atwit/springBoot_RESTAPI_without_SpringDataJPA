package com.learning.SpringBoot.restAPIDemo.service;

import java.util.List;

import com.learning.SpringBoot.restAPIDemo.entity.Employee;

public interface EmployeeService {
  List<Employee> findAll();

  Employee findById(int theId);

  Employee save(Employee theEmployee);

  void deleteById(int theId);
}
