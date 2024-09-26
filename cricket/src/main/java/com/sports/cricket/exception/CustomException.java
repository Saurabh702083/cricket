package com.sports.cricket.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class CustomException extends Exception {
    int errorCode;
    String errorMessage;




    public CustomException(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
