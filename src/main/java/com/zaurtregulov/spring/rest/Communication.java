package com.zaurtregulov.spring.rest;

import com.zaurtregulov.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;

    private String URL = "http://localhost:8080/spring_course_rest/api/employees";



    public List<Employee> getALlEmployees(){

        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});

        List<Employee> allEmployees = responseEntity.getBody();

        return allEmployees;

    }


    public Employee getEmployee(int id){
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return employee;
    }



    public void saveEmployee(Employee employee){
        if(employee.getId() == 0){
            restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New emp added");
        }
        else{
            restTemplate.put(URL, employee);
            System.out.println("Emp updated");
        }
    }



    public void deleteEmployee(int id){
        restTemplate.delete(URL, id);
    }

}




















