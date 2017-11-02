package com.zzz.controller;

import com.zzz.domain.User;
import com.zzz.domain.UserInfo;
import com.zzz.service.UserService;
import com.zzz.support.*;
import com.zzz.support.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
                .result(userService.findAllUser())
                .build();
    }

    @GetMapping("/findUserById/{id}")
    public ResponseEntity findUserById(@PathVariable("id") Long id) {
        return ResponseEntity.builder()
                .msgCode(200)
                .msgContent("success")
                .result(userService.findUserById(id))
                .build();
    }

    @PostMapping("findAllMaleUserInfo")
    public ResponseEntity findAllMaleUserInfo() {
        return ResponseEntity.builder()
                .msgCode(200)
                .msgContent("success")
                .result(userService.findAllMaleUserInfo())
                .build();
    }

    @GetMapping("/findAllUserId")
    public ResponseEntity findAllUserId() {
        return ResponseEntity.builder()
                .msgCode(200)
                .msgContent("success")
                .result(userService.findAllUserId())
                .build();
    }

    @RequestMapping("/saveUser")
    public ResponseEntity saveUser(User user) {
        userService.saveUser(user);
        return ResponseEntity.builder()
                .msgCode(200)
                .msgContent("保存成功")
                .build();
    }

    @RequestMapping("/findAllUserInfo")
    public ResponseEntity findAllUserInfo(Integer page, Integer size) {
        page = page == null ? 1 : page;

        if (page < 0) {
            return new ResponseEntity(ResponseStatus.REQUEST_PARAM_EXCEPTION);
        }

        Pageable pageable = new PageRequest(page - 1, size);

        Page<UserInfo> pageRs = userService.findAllUserInfo(pageable);

        return new ResponseEntity(ResponseStatus.SUCCESS, this.convertPage2PageResult(pageRs));
    }

    @RequestMapping(value = "/findBySex", method = RequestMethod.POST)
    public ResponseEntity findBySex(Integer sex, Integer page, Integer size) {
        page = page == null ? 1 : page;
        Pageable pageable = new PageRequest(page - 1, size);

        Page<UserInfo> pageRs = userService.findBySex(sex, pageable);

        return ResponseEntity.builder()
                .msgCode(200)
                .msgContent("查询成功")
                .result(this.convertPage2PageResult(pageRs))
                .build();
    }

    /**
     * page之间的转换
     * @param tPage
     * @param <T>
     * @return
     */
    private <T>PageResult<T> convertPage2PageResult(Page<T> tPage) {
        return PageResult.<T>builder()
                .curPage(tPage.getNumber() + 1)
                .totalPages(tPage.getTotalPages())
                .totalElements(tPage.getTotalElements())
                .content(tPage.getContent())
                .build();
    }

}
