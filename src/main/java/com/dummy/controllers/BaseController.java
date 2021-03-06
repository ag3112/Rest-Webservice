package com.dummy.controllers;

import com.dummy.beans.*;
import com.dummy.beans.Error;
import com.dummy.dao.DataRepository;
import com.dummy.exception.DataException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Intel on 8/30/2015.
 */
@RestController
public class BaseController implements InitialController<Students> {

    private static final Log logger = LogFactory.getLog(BaseController.class);

    private DataRepository dataRepository;

    @Autowired
    private Students students;

    @Autowired
    public BaseController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET, produces = "application/xml")
    @ResponseStatus(HttpStatus.OK)
    @Secured("ROLE_ADMIN")
    public Students getStudentDetail() {
        logger.info("Got 'Get' request for all student details");
        List<Student> studentList = this.dataRepository.getStudentDetails();
        students.setStudentList(studentList);
        return students;
    }

    @RequestMapping(value = "/studentById", method = RequestMethod.GET, produces = "application/xml")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    public Student getStudentDetailById(@RequestParam(value = "id") Long id) throws DataException {
        logger.info("Got 'Get' request for a student whose id is [ "+id+" ]");
        Student student = this.dataRepository.getStudentDetailsByID(id);
        if(student == null){
            throw new DataException("No Student detail found for Id [ "+id+" ]");
        }
        return student;
    }

    @RequestMapping(value = "/studentById/{id}", method = RequestMethod.GET, produces = "application/xml")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentDetailByIdPath(@PathVariable Long id) throws DataException {
        logger.info("Got 'Get' request for a student whose id is [ "+id+" ]");
        Student student = this.dataRepository.getStudentDetailsByID(id);
        if(student == null){
            throw new DataException("No Student detail found for Id [ "+id+" ]");
        }
        return student;
    }

    // Below code can be used as client to access above method !!

    /*RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Students> studentList = restTemplate.getForEntity("http://localhost:8080/rest-webservice/student", Students.class);
    if(studentList.getStatusCode() == HttpStatus.OK){
        for(Student student:studentList.getBody().getStudentList()){
            System.out.println(student.toString());
        }
    }else{
        System.out.println("Problem !!");
    }*/

    @RequestMapping(value = "/student", method = RequestMethod.POST, produces = "application/xml", consumes = "application/xml")
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveStudent(@RequestBody Student student) throws DataException {
        logger.info("Inserting " + student.toString());
        try{
            this.dataRepository.saveStudentDetails(student);
        }catch(Exception he){
            DataException de =  new DataException(he.getCause().getCause().getMessage());
            de.initCause(he);
            throw de;
        }
        return student;
    }

    @ExceptionHandler(DataException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Error anyException(DataException de){
        return new Error(HttpStatus.CONFLICT.value(),de.getMessage());
    }

}
