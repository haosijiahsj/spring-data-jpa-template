package com.zzz.controller;

import com.zzz.domain.User;
import com.zzz.service.UserService;
import com.zzz.support.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.builder()
                .msgCode(200)
                .msgContent("success")
                .content(userService.findAllUser())
                .build();
    }

    @GetMapping("findUserById/{id}")
    public ResponseEntity findUserById(@PathVariable("id") Long id) {
        return ResponseEntity.builder()
                .msgCode(200)
                .msgContent("success")
                .content(userService.findUserById(id))
                .build();
    }

    @PostMapping("findAllMaleUserInfo")
    public ResponseEntity findAllMaleUserInfo() {
        return ResponseEntity.builder()
                .msgCode(200)
                .msgContent("success")
                .content(userService.findAllMaleUserInfo())
                .build();
    }

    @GetMapping("findAllUserId")
    public ResponseEntity findAllUserId() {
        return ResponseEntity.builder()
                .msgCode(200)
                .msgContent("success")
                .content(userService.findAllUserId())
                .build();
    }

}
