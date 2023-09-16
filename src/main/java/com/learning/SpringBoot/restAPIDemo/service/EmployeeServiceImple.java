package com.learning.SpringBoot.restAPIDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.SpringBoot.restAPIDemo.dao.EmployeeDAO;
import com.learning.SpringBoot.restAPIDemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImple implements EmployeeService {

  private EmployeeDAO employeeDAO;

  @Autowired
  public EmployeeServiceImple(EmployeeDAO theEmployeeDAO) {
    employeeDAO = theEmployeeDAO;
  }

  @Override
  public List<Employee> findAll() {
    return employeeDAO.findAll();
  }

  @Override
  public Employee findById(int theId) {
    return employeeDAO.findById(theId);
  }

  // for both save and update
  @Transactional
  @Override
  public Employee save(Employee theEmployee) {
    return employeeDAO.save(theEmployee);
  }

  @Transactional
  @Override
  public void deleteById(int theId) {
    employeeDAO.deleteById(theId);
  }

}
