package com.dummy.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Intel on 9/13/2015.
 */
@XmlRootElement
public class Error {

    private int code;

    private String message;

    public Error(){
        // default constructor !!
    }

    public Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @XmlElement
    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    @XmlElement
    public void setMessage(String message) {
        this.message = message;
    }
}
