package com.example.sampleCBproject.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private String empId;
    private String name;
    private String teamName;

    public Employee(String empId, String name, String teamName) {
        this.empId = empId;
        this.name = name;
        this.teamName = teamName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Employee(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
    }

    public Employee() {
    }
}
