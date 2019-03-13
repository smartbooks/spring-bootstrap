package com.github.smartbooks.bootstrap.viewmodel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 用户登录请求
 */
public class PassportLoginRequest {

    @NotEmpty(message = "登录账号不能为空")
    @Size(min = 5, max = 32, message = "只允许5至32个字符")
    private String userName;

    @NotEmpty(message = "账号密码不能为空")
    @Size(min = 6, max = 32, message = "只允许6至32个字符")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
