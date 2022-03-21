package com.example.sampleCBproject.service;

import com.example.sampleCBproject.entity.Employee;
import com.example.sampleCBproject.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getUsers() {
        List<Employee> emp = new ArrayList<>();
        employeeRepository.findAll().forEach(emp::add);
        return emp;
    }

    public HttpStatus postUser(Employee e) {
        try {
            employeeRepository.save(e);
            return HttpStatus.ACCEPTED;
        } catch (Exception ex) {
            ex.printStackTrace();
            return HttpStatus.BAD_REQUEST;
        }
    }

    public Optional<Employee> getOneUser(String id) {
        return employeeRepository.findById(id);
    }

    public HttpStatus deleteUser(String id) {
        employeeRepository.deleteById(id);
        return HttpStatus.ACCEPTED;
    }

    public HttpStatus putUsers(Iterable<Employee> e) {
        employeeRepository.saveAll(e);
        return HttpStatus.CREATED;
    }

}
