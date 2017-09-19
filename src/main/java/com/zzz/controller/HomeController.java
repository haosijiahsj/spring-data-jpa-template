package com.zzz.controller;

import com.zzz.domain.User;
import com.zzz.service.UserService;
import com.zzz.support.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hushengjun on 2017/9/14.
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        return "HELLO";
    }

    @RequestMapping("/allUser")
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @RequestMapping(value = "/findAllUser", method = RequestMethod.POST)
    public ResponseEntity findUser() {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setMsgCode(200);
        responseEntity.setMsgContent("success");
        responseEntity.setContent(userService.findAllUser());

        return responseEntity;
    }

}
