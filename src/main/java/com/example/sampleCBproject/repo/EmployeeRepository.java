package com.example.sampleCBproject.repo;

import com.example.sampleCBproject.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,String> {
}
