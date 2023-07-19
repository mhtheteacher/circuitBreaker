package com.learningcenter.studentservice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

import org.springframework.cloud.circuitbreaker.resilience4j.*;
@RestController
public class StudentserviceController {

    RestTemplate restTemplate = new RestTemplate();
    String courseServURL="http://localhost:8080/courses";
    public static final String STUDENT_SERV="StudentService";

     

    
@RequestMapping(value = "/", method = RequestMethod.GET)
@CircuitBreaker(name =STUDENT_SERV,fallbackMethod = "getAllAvailableCourses")

public List<Courses> getCourses(){
    return restTemplate.getForObject(courseServURL,ArrayList.class);
	}
    public List<Courses> getAllAvailableCourses(Exception e){
        return Stream.of( new Courses(1, "Automata", "SoftwareEngineering", 100)
                
        ).collect(Collectors.toList());
    }


    
}
