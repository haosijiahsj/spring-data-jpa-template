package com.zzz.service;

import com.zzz.domain.User;
import com.zzz.domain.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by hushengjun on 2017/9/7.
 */
public interface UserService {

    List<User> findAllUser();

    User findUserById(Long id);

    List<UserInfo> findAllMaleUserInfo();

    List<Long> findAllUserId();

    void saveUser(User user);

    Page<UserInfo> findAllUserInfo(Pageable pageable);

    Page<UserInfo> findBySex(Integer sex, Pageable pageable);

    Page<UserInfo> findByNameLike(String name, Pageable pageable);

}