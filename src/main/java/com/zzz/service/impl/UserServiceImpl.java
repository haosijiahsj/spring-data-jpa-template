package com.zzz.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.zzz.dao.UserInfoRepository;
import com.zzz.dao.UserRepository;
import com.zzz.domain.User;
import com.zzz.domain.UserInfo;
import com.zzz.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public void saveUser(User user) {
        Preconditions.checkNotNull(user, "入参user不能为空！");
        Preconditions.checkNotNull(user.getUserInfo(), "入参userInfo不能为空！");
        userRepository.save(user);
    }

    @Override
    public Page<UserInfo> findAllUserInfo(Pageable pageable) {
        return userInfoRepository.findAll(pageable);
    }

    @Override
    public Page<UserInfo> findBySex(Integer sex, Pageable pageable) {
        Preconditions.checkNotNull(sex, "入参sex不能为空！");
        return userInfoRepository.findBySex(sex, pageable);
    }

    @Override
    public Page<UserInfo> findByNameLike(String name, Pageable pageable) {
        Preconditions.checkArgument(StringUtils.isNoneEmpty(name), "入参name不能为空！");
        return userInfoRepository.findByNameLike(name, pageable);
    }

}
