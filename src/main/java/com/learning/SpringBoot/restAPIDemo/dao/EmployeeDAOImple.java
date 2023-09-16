package com.learning.SpringBoot.restAPIDemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.SpringBoot.restAPIDemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImple implements EmployeeDAO {

  // define field for entity manager
  private EntityManager entityManager;

  // set up constructor injection
  @Autowired
  public EmployeeDAOImple(EntityManager theEntityManager) {
    entityManager = theEntityManager;
  }

  @Override
  public List<Employee> findAll() {

    // create a query
    TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

    // execute query and get result list
    List<Employee> employees = theQuery.getResultList();

    // return the results
    return employees;
  }

  @Override
  public Employee findById(int theId) {
    // get employee id
    Employee theEmployee = entityManager.find(Employee.class, theId);

    // return employee
    return theEmployee;
  }

  @Override
  public Employee save(Employee theEmployee) {
    // save the employee
    Employee dbEmployee = entityManager.merge(theEmployee);

    // return the employee
    return dbEmployee;
  }

  @Override
  public void deleteById(int theId) {
    // get the employee id
    Employee theEmployee = entityManager.find(Employee.class, theId);

    // delete object with primary key
    entityManager.remove(theEmployee);
  }

}
