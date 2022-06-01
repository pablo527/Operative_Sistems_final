package com.example.kernel.controller;

import com.example.kernel.model.MessageLog;
import com.example.kernel.util.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@ControllerAdvice
public class ControllerExceptionHandler {
    public static final Logger logger = LogManager.getLogger(ControllerExceptionHandler.class);
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    MessageLog exceptionHandler(Exception e) throws JsonProcessingException {
        String idFailure = UUID.randomUUID().toString();
        var messageLog = new MessageLog();
        messageLog.setData(e.getMessage());
        messageLog.setMsg(String.format(Message.UNEXPECTED_ERROR,idFailure));
        messageLog.setId(idFailure);
        logger.error(messageLog.getData());
        ObjectMapper objectMapper = new ObjectMapper();
        String usuarioJson = objectMapper.writeValueAsString(messageLog);
        logger.error(usuarioJson);
        logger.info("PEPE GANGA");
        return messageLog;
    }
}
