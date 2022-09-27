package com.example.lombook.Dto;

import lombok.Data;

@Data
public class ResponseDto {

    String message;
    Object data;

    public ResponseDto() {
    }

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public ResponseDto(String message) {
        this.message = message;
    }
}