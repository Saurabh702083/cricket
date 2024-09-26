package com.sports.cricket.exception;


///import com.WeCare.WeCare.Error.ErrorMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sports.cricket.Error.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({MethodArgumentNotValidException.class})
    ResponseEntity<List<String>> handleMethodArgument(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<String> errors = new ArrayList();
        Iterator var3 = methodArgumentNotValidException.getBindingResult().getFieldErrors().iterator();

        while(var3.hasNext()) {
            FieldError error = (FieldError)var3.next();
            String var10001 = error.getField();
            errors.add(var10001 + " is invalid value :- " + error.getDefaultMessage());
        }

        return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CustomException.class})
    ResponseEntity<ErrorMessage> handleCustomException(CustomException customException) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage(customException.errorMessage);
        errorMessage.setErrorCode(customException.errorCode);
        errorMessage.setRemediation("please provide valid values");
        return new ResponseEntity(errorMessage, HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler({Exception.class})
    ResponseEntity<ErrorMessage> handleUnknownError(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage(exception.getMessage());
        errorMessage.setErrorCode(503);
        errorMessage.setRemediation("Unknown error occurred");
        return new ResponseEntity(errorMessage, HttpStatusCode.valueOf(500));
    }
}
