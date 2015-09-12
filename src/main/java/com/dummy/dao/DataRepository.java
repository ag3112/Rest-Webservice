package com.dummy.dao;

import com.dummy.beans.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Intel on 8/30/2015.
 */
@Repository
@org.springframework.transaction.annotation.Transactional
public class DataRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveStudentDetails(Student student) {
        Serializable id = sessionFactory.getCurrentSession().save(student);
    }

    public List<Student> getStudentDetails() {
        List<Student> studentList = sessionFactory.getCurrentSession().createCriteria(Student.class).list();
        return studentList;
    }
}
