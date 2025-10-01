package com.hansreidan.store.payroll.controllers;


import com.hansreidan.store.payroll.domain.Employee;
import com.hansreidan.store.payroll.exceptions.EmployeeNotFoundException;
import com.hansreidan.store.payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller
public class EmployeeController {


    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employess")
    Employee newEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees/{id}")
    EntityModel<Employee> one(@PathVariable Long id) {
//        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));

        return EntityModel.of(employee, //
                linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).findAll()).withRel("employees"));

//        linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel() asks
//        that Spring HATEOAS build a link to the one method of EmployeeController and flag it as a self link.
//
//        linkTo(methodOn(EmployeeController.class).all()).withRel("employees") asks
//        Spring HATEOAS to build a link to the aggregate root, all(), and call it "employees".
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return employeeRepository.save(employee);
                })
                .orElseGet(() -> employeeRepository.save(newEmployee));
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
