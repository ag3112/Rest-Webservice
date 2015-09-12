package com.dummy.controllers;

import com.dummy.beans.Student;
import com.dummy.beans.Students;
import com.dummy.dao.DataRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intel on 8/30/2015.
 */
@RestController
public class BaseController {

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
    public Students getStudentDetail() {
        logger.info("Got 'Get' request for all student details");
        List<Student> studentList = this.dataRepository.getStudentDetails();
        students.setStudentList(studentList);
        return students;
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveStudent(@RequestBody Student student) {
        logger.info("Inserting " + student.toString());
        this.dataRepository.saveStudentDetails(student);
        return student;
    }

}
