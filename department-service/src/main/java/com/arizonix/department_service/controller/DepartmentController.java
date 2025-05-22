package com.arizonix.department_service.controller;

import com.arizonix.department_service.client.EmployeeClient;
import com.arizonix.department_service.model.Department;
import com.arizonix.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private EmployeeClient employeeClient;


    @PostMapping("/add")
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add: {}", department);
        return repository.addDepartment(department);
    }

    @GetMapping("/list")
    public List<Department> findAll(){
        LOGGER.info("Department find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("Department find: id ={} ",id);
        return repository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("Find Employees from same department");
        List<Department> departments = repository.findAll();
        departments.forEach( department ->
                department
                        .setEmployees(employeeClient.findByDepartment(department.getId())));
        return repository.findAll();
    }
}
