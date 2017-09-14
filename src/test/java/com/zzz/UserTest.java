package com.zzz;

import com.zzz.domain.User;
import com.zzz.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by hushengjun on 2017/9/14.
 */
public class UserTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void findAllUserTest() {
        List<User> users = userService.findAllUser();
        Assert.assertNotNull(users);
        Assert.assertFalse(users.isEmpty());
    }

    @Test
    public void findUserByIdTest() {
        User user = userService.findUserById(10000L);
        Assert.assertNotNull(user);
    }

}
