package com.github.smartbooks.bootstrap.controller.rest;

import com.github.smartbooks.bootstrap.exception.TestException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/world")
    public Long world() {

        return System.currentTimeMillis();

    }

    @RequestMapping("/testerror")
    public String testError() {

        throw new TestException("测试Controller throw异常");
    }

}
