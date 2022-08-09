package com.bezkoder.spring.jpa.h2.controller;

import com.bezkoder.spring.jpa.h2.model.Employee;
import com.bezkoder.spring.jpa.h2.repository.EmployeeService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Select, Insert, Delete, Update Operations for an Employee

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    Employee getEmployee(@PathVariable Integer id){
        return  employeeService.findById(id).get();
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    Employee addEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.save(employee);
        return savedEmployee;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    Employee updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.save(employee);
        return updatedEmployee;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.DELETE)
    JSONObject deleteEmployee(@RequestParam Integer id){
        Map<String, String> status = new HashMap<>();
        Optional<Employee> employee = employeeService.findById(id);
        JSONObject jsonObject;
        if(employee.isPresent()) {
            employeeService.delete(employee.get());
            status.put("message", "Employee deleted successfully");
            status.put("Status", "204");
        }
        else {
            status.put("message", "Employee not exist");
            status.put("Status", "404");
        }

        return new JSONObject(status);
    }

    // Select, Insert, Delete for List of Employees

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    List<Employee> getAllEmployee(){
        return employeeService.findAll();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    List<Employee> addAllEmployees(@RequestBody List<Employee> employeeList){
        employeeService.saveAll(employeeList);
        return employeeService.saveAll(employeeList);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.DELETE)
    String addAllEmployees(){
        employeeService.deleteAll();
        return "SUCCESS";
    }
}
