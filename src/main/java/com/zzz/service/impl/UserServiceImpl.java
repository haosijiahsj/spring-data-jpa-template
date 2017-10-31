package com.zzz.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.zzz.dao.UserInfoRepository;
import com.zzz.dao.UserRepository;
import com.zzz.domain.User;
import com.zzz.domain.UserInfo;
import com.zzz.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ok
 * Created by hushengjun on 2017/9/14.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        Preconditions.checkNotNull(id, "查询参数id不能为空");
        return userRepository.findById(id);
    }

    @Override
    public List<UserInfo> findAllMaleUserInfo() {
        return userInfoRepository.findAll()
                .filter((userInfo) -> userInfo.getSex() != 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> findAllUserId() {
        List<User> users = userRepository.findAll();

        if (CollectionUtils.isNotEmpty(users)) {
            return Lists.transform(users, User::getId);
        }

        return Collections.emptyList();
    }

}
