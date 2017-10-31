package com.zzz.dao;

import com.zzz.domain.UserInfo;
import org.springframework.data.repository.Repository;

import java.util.stream.Stream;

/**
 * Created by hushengjun on 2017/9/14.
 */
public interface UserInfoRepository extends Repository<UserInfo, Long> {

    Stream<UserInfo> findAll();

}
