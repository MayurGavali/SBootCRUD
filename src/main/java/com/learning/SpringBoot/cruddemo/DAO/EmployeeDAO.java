package com.learning.SpringBoot.cruddemo.DAO;

import com.learning.SpringBoot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO{

    public List<Employee> findAll();

    public Employee findbyId(int theId);

    public void save(Employee theEmployee);

    public void deleteById(int theId);

}