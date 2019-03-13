package com.github.smartbooks.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用程序入口点
 * 开启调度计划
 * <p>
 * 参考教程:https://www.yiibai.com/spring-boot
 *
 * @EnableScheduling
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);

    }

}
