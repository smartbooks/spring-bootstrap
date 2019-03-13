package com.github.smartbooks.bootstrap.controller.help;

import com.github.smartbooks.bootstrap.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 帮助文档中心
 */
@Controller
@RequestMapping("/help/helpcenter")
public class HelpCenterController extends BaseController {

    @GetMapping("/index")
    public String index(Model model) {
        return "/help/helpcenter/index";
    }

}
