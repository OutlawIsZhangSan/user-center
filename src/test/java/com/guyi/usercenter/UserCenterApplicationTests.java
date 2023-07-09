package com.guyi.usercenter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

/**
 * 启动类
 */
@SpringBootTest
//@RunWith(SpringRunner.class)
public class UserCenterApplicationTests {
    /**
     * 测试密码加密
     */
    @Test
    void testDigest() {
        String newPassword = DigestUtils.md5DigestAsHex(("abcd" + "mypassword").getBytes());
        System.out.println(newPassword);
    }
}