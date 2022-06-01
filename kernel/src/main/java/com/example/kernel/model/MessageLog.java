package com.example.kernel.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MessageLog<T>{
   private T data;
   private String id;
   private String cmd;
   private String src;
   private String dst;
   private String msg;

}
