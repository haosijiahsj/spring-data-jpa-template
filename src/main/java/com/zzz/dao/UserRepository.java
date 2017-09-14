package com.zzz.dao;

import com.zzz.domain.User;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by hushengjun on 2017/9/14.
 */
public interface UserRepository extends Repository<User, Long> {

    List<User> findAll();

    User findById(Long id);

}
