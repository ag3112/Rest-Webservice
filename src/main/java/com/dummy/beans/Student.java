package com.dummy.beans;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Intel on 9/6/2015.
 */

@Entity
@XmlRootElement
@Table(name = "student_details")
public class Student {

    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "contactnumber")
    Long contactNumber;

    @Column(name = "fathername")
    String fatherName;

    @Column(name = "mothername")
    String motherName;

    @Column(name = "guardianname")
    String guardianName;

    @Column(name = "address")
    String address;

    public Long getId() {
        return id;
    }

    @XmlElement
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public Long getContactNumber() {
        return contactNumber;
    }


    @XmlElement
    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    @XmlElement
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    @XmlElement
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGuardianName() {
        return guardianName;
    }

    @XmlElement
    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNumber=" + contactNumber +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", guardianName='" + guardianName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
