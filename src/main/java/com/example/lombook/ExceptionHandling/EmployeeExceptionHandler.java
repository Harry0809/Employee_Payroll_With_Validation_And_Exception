package com.example.lombook.ExceptionHandling;

import com.example.lombook.Dto.EmployeeDto;
import com.example.lombook.Dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(EmployeeException exception) {
        ResponseDto responseDto = new ResponseDto("Exception while parsing Rest request", exception.getMessage());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errorMessage = errorList.stream().map(ObjectError -> ObjectError.getDefaultMessage()).collect(Collectors.toList());
        ResponseDto responseDto = new ResponseDto("Exception while parsing rest request", errorMessage);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);

    }

}
