package com.github.smartbooks.bootstrap.controller;

import com.github.smartbooks.bootstrap.viewmodel.PassportLoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * 授权中心
 */
@Controller
@RequestMapping("/passport")
public class PassportController extends BaseController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(
            Model model,
            @ModelAttribute("entity") PassportLoginRequest entity,
            HttpSession httpSession) {

        model.addAttribute("page_error", httpSession.getAttribute("page_error"));

        return "/passport/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            Model model,
            @ModelAttribute("entity") @Validated PassportLoginRequest entity,
            BindingResult result) {

        if (result.hasErrors()) {

            //model.addAttribute("page_error","");
            //result.rejectValue("userName", "100", "用户名已存在");

            return "/passport/login";
        }

        return "redirect:/home/index";
    }

    @RequestMapping(value = "/loginoutok", method = RequestMethod.GET)
    public String loginout(Model model, HttpSession httpSession) {
        return "/passport/loginoutok";
    }

    @GetMapping("/unauthorized")
    public String unAuthorized(Model model) {
        //提示用户没有资源访问权限
        return "/passport/unauthorized";
    }

    @GetMapping("/nopermission")
    public String noPermission(Model model) {
        //用户尚未分配权限
        return "/passport/nopermission";
    }

    @GetMapping("/uninitpermission")
    public String unInitPermission(Model model) {
        //权限清单未初始化
        return "/passport/uninitpermission";
    }
}
