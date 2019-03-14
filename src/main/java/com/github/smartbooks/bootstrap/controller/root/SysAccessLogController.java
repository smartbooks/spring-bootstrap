package com.github.smartbooks.bootstrap.controller.root;

import com.github.smartbooks.bootstrap.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/root/sysaccesslog")
public class SysAccessLogController extends BaseController {

    @RequestMapping("/list")
    public String list(
            Model model,
            @RequestParam(value = "pageindex", defaultValue = "0") Integer pageIndex,
            @RequestParam(value = "pagesize", defaultValue = "20") Integer pageSize,
            HttpServletRequest request) {

        model.addAttribute("page_data", null);

        return "/root/sysaccesslog/list";
    }

}
