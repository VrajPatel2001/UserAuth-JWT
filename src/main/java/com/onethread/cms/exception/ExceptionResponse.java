package com.onethread.cms.exception;

import java.util.Date;

public class ExceptionResponse{
    private Date timestamps;
    private String message;
    private String details;

    public ExceptionResponse(Date timeStamps, String message, String details) {
        this.timestamps = timeStamps;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Date timestamps) {
        this.timestamps = timestamps;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "timeStamps=" + timestamps +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}

