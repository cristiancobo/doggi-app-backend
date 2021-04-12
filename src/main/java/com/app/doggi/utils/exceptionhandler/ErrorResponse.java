package com.app.doggi.utils.exceptionhandler;

import java.util.Date;
import java.util.List;

/**
 * Class representing a error response
 * @version 1.0
 *
 */
public class ErrorResponse {

    public ErrorResponse(String message) {
        this.message = message;

    }
    public ErrorResponse() {

    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Date getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
    public List<String> getErrors() {
        return errors;
    }
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
    private int status;

    private String message;

    private Date timeStamp;

    List<String> errors;
}
