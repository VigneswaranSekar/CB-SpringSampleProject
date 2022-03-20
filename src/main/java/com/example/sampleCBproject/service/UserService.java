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

    private List<Employee> myEmployees = new ArrayList<>();

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getUsers() {
//         return myEmployees;
        List<Employee> emp = new ArrayList<>();
        employeeRepository.findAll().forEach(emp::add);
        return emp;
    }

    public HttpStatus postUser(Employee e) {
//        myEmployees.add(e);
        try {
            employeeRepository.save(e);
            return HttpStatus.ACCEPTED;
        } catch (Exception ex) {
            ex.printStackTrace();
            return HttpStatus.BAD_REQUEST;
        }
    }

    public Optional<Employee> getOneUser(String id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        return emp;
    }

    public HttpStatus deleteUser(String id) {
        employeeRepository.deleteById(id);
        return HttpStatus.ACCEPTED;
    }
}
