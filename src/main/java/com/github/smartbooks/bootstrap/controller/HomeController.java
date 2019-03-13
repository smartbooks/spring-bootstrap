package com.github.smartbooks.bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * 管理主页
 * http://localhost:8080/home/index?language=[zh_CN|en_US]
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {

    /**
     * 国际化资源文件
     */
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/index")
    public String index(Model model, Locale locale) {

        model.addAttribute("msg", "HelloWorld");

        model.addAttribute("lang", messageSource.getMessage("welcome.text", null, locale));

        return "/home/index";
    }

    @GetMapping("/error")
    public String error() throws Exception {
        throw new Exception("test Exception");
    }

}
