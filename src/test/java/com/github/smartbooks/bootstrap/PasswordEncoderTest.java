package com.github.smartbooks.bootstrap;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {

    @Test
    public void encoderPassword() {

        String password = "000000";

        String salt = "000000";

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String pwd = bCryptPasswordEncoder.encode(password + salt);

        System.out.println(pwd);

    }

}
