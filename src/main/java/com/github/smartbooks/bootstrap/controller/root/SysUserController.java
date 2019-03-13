package com.github.smartbooks.bootstrap.controller.root;

import com.github.smartbooks.bootstrap.controller.BaseController;
import com.github.smartbooks.bootstrap.dao.entity.SysUser;
import com.github.smartbooks.bootstrap.service.SysUserService;
import com.github.smartbooks.bootstrap.util.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 用户管理完整示例
 */
@Controller
@RequestMapping("/root/sysuser")
public class SysUserController extends BaseController {

    /**
     * 自动装配
     */
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/list")
    public String list(
            Model model,
            @RequestParam(value = "pageindex", defaultValue = "0") Integer pageIndex,
            @RequestParam(value = "pagesize", defaultValue = "20") Integer pageSize,
            HttpServletRequest request) {

        for (Map.Entry<String, String[]> item : request.getParameterMap().entrySet()) {

            logger.debug(String.format("k=%s v=%s", item.getKey(), item.getValue().toString()));

        }

        logger.debug(String.format("page_index:%s page_size:%s", pageIndex, pageSize));

        model.addAttribute("page_data", sysUserService.list(new Paging(pageIndex, pageSize)));

        return "/root/sysuser/list";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(
            Model model,
            @RequestParam(name = "id") Long id) {

        model.addAttribute("page_data", sysUserService.find(id));

        return "/root/sysuser/view";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        return "/root/sysuser/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(
            Model model,
            @ModelAttribute @Valid SysUser sysUser,
            Errors errors) {

        String error_message = "";

        if (errors.hasErrors()) {
            List<ObjectError> objectErrorList = errors.getAllErrors();
            for (ObjectError objectError : objectErrorList) {
                error_message += objectError.toString();
            }
        }

        model.addAttribute("page_error", error_message);

        logger.debug(String.format("model:%s", sysUser));

        if (errors.hasErrors()) {

            return "/root/sysuser/add";

        } else {

            return "redirect:/root/sysuser/list";

        }
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del(
            Model model,
            @RequestParam(name = "id") Long id) {

        logger.debug(String.format("id:%s ", id));

        sysUserService.delete(id);

        return "redirect:/root/sysuser/list";
    }

    @RequestMapping(value = "/put", method = RequestMethod.GET)
    public String put(
            Model model,
            @RequestParam(name = "id") Long id) {

        logger.debug(String.format("id:%s", id));

        model.addAttribute("page_data", sysUserService.find(id));

        return "/root/sysuser/put";
    }

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public String put(
            Model model,
            @ModelAttribute @Valid SysUser sysUser,
            Errors errors) {

        logger.debug(String.format("model:%s", sysUser));

        sysUserService.update(sysUser.getId(), sysUser);

        return "redirect:/root/sysuser/list";
    }

}
