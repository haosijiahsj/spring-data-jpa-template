package com.zzz.dao;

import com.zzz.domain.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.stream.Stream;

/**
 * userInfoDao
 * Created by hushengjun on 2017/9/14.
 */
public interface UserInfoRepository extends Repository<UserInfo, Long> {

    Stream<UserInfo> findAll();

    Page<UserInfo> findAll(Pageable pageable);

    Page<UserInfo> findBySex(Integer sex, Pageable pageable);

    Page<UserInfo> findByNameLike(String name, Pageable pageable);

}
