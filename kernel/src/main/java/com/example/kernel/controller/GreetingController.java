package com.example.kernel.controller;

import com.example.kernel.model.Greeting;
import com.example.kernel.model.MessageLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greeting")
    public Greeting sendGreeting(MessageLog messageLog){
        System.out.println("Mensaje");
        return new Greeting("Hello,");
    }

    @GetMapping("/pet")
    public ResponseEntity<Integer> getLogs(){
        int  suma = 0/0;
        return new ResponseEntity<>(suma, HttpStatus.OK);
    }
}
