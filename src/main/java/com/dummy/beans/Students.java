package com.dummy.beans;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Intel on 9/12/2015.
 */
@XmlRootElement(name = "Students")
@Component
public class Students implements BaseBean{

    private List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }

    @XmlElement(name = "Student")
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
