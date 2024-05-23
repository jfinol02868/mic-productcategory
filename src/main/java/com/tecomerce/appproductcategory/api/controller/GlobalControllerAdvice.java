package com.tecomerce.appproductcategory.api.controller;

import com.tecomerce.appproductcategory.api.service.dto.MessageResponseDTO;
import com.tecomerce.appproductcategory.domain.exception.EntityNotFoundException;
import com.tecomerce.appproductcategory.domain.valueobject.enums.MessageEnum;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public MessageResponseDTO handlerEntityNotFoundException(EntityNotFoundException ex) {
        return MessageResponseDTO.builder()
                .code("E001")
                .message(MessageEnum.ENTITY_NOT_FOUND.getMessage())
                .details(new ArrayList<>())
                .timeStamp(ZonedDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MessageResponseDTO handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return MessageResponseDTO.builder()
                .code("B001")
                .message(MessageEnum.METHOD_ARGUMENT_NOT_VALID.getMessage())
                .details(e.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .toList())
                .timeStamp(ZonedDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public MessageResponseDTO handlerGenericError(Exception e) {
        return MessageResponseDTO.builder()
                .code("")
                .message("")
                .details(Collections.singletonList(e.getMessage()))
                .timeStamp(ZonedDateTime.now())
                .build();
    }
}
