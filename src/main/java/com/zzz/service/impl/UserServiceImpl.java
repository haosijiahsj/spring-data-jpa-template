package com.zzz.service.impl;

import com.google.common.base.Preconditions;
import com.zzz.dao.UserRepository;
import com.zzz.domain.User;
import com.zzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hushengjun on 2017/9/14.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        Preconditions.checkNotNull(id, "查询参数id不能为空");
        return userRepository.findById(id);
    }
}
