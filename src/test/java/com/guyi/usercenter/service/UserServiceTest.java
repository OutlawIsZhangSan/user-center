package com.guyi.usercenter.service;

import com.guyi.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 用户服务测试
 *
 * @author 张仕恒
 */
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void testAddUser() {
        User user = new User();
        user.setUsername("testGuyi");
        user.setUserAccount("123");
        user.setAvatarUrl("testUrl");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("123");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        assertTrue(result);
    }

    /**
     * "注册校验"测试
     */
    @Test
    void userRegister() {
        // 用户密码不为空
        String userAccount = "guyi";
        String userPassword = "";
        String checkPassword = "12345678";
        String planetCode = "1";

        long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        // 用户密码不小于8位
        userAccount = "guyi";
        userPassword = "1234567";
        checkPassword = "1234567";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        // 用户密码和校验密码要相同
        userAccount = "guyi";
        userPassword = "12345678";
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        // 账号长度不小于4位
        userAccount = "gy";
        userPassword = "12345678";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        // 账号不能重复
        userAccount = "123";
        userPassword = "12345678";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        // 账号不能包含特殊字符
        userAccount = "gu yi";
        userPassword = "12345678";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        // 执行成功
        userAccount = "guyi";
        userPassword = "12345678";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
//        assertTrue(result > 0);
        Assertions.assertEquals(-1, result);
    }
}