package com.arizonix.department_service.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private Long id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
