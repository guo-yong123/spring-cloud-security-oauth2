package com.tl.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
         @Author : guoyong
         @Description :
         @ToDo :
         @Date 2019/12/1 19:52
         @Email : guo-yong123@163.com
   **/
  @RestController
public class UserController {

      @GetMapping(value = "/user/info/{userId}")
      public String getUserInfo(@PathVariable String userId){
          return "user:"+userId;
      }

}
