package com.github.smartbooks.bootstrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 个人中心
 */
@Controller
@RequestMapping("/profile")
public class ProfileController extends BaseController {

    @GetMapping("/index")
    public String index(Model model) {
        return "/profile/index";
    }

    @GetMapping("/modifyPassword")
    public String modifyPassword(Model model) {
        return "/profile/modifyPassword";
    }

    @PostMapping("/modifyPassword")
    public String modifyPassword(Model model, Errors errors) {
        return "/profile/modifyPassword";
    }

}
