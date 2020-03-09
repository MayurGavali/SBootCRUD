package com.learning.SpringBoot.cruddemo.service;

import com.learning.SpringBoot.cruddemo.DAO.EmployeeDAO;
import com.learning.SpringBoot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO1) {
        this.employeeDAO = theEmployeeDAO1;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return employeeDAO.findbyId(theId);
    }

    @Override
    public void save(Employee theEmployee) {
        employeeDAO.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
    employeeDAO.deleteById(theId);
    }
}
