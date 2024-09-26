package com.sports.cricket.Error;
import lombok.Data;
import lombok.Generated;
@Data
public class ErrorMessage {
    private int errorCode;
    private String errorMessage;
    private String remediation;

    public ErrorMessage(int errorCode, String errorMessage, String remediation) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.remediation = remediation;
    }

    public ErrorMessage() {
    }

    public ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}

