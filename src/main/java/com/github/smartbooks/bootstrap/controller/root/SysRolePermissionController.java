package com.github.smartbooks.bootstrap.controller.root;

import com.github.smartbooks.bootstrap.controller.BaseController;
import com.github.smartbooks.bootstrap.viewmodel.root.SysPermissionAddRequest;
import com.github.smartbooks.bootstrap.viewmodel.root.SysPermissionPutRequest;
import com.github.smartbooks.bootstrap.viewmodel.root.SysRolePermissionAddRequest;
import com.github.smartbooks.bootstrap.viewmodel.root.SysRolePermissionPutRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/root/sysrolepermission")
public class SysRolePermissionController extends BaseController {

    @RequestMapping("/list")
    public String list(
            Model model,
            @RequestParam(value = "pageindex", defaultValue = "0") Integer pageIndex,
            @RequestParam(value = "pagesize", defaultValue = "20") Integer pageSize,
            HttpServletRequest request) {

        model.addAttribute("page_data", null);

        return "/root/sysrolepermission/list";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(
            Model model,
            @RequestParam(name = "id") Long id) {

        model.addAttribute("page_data", null);

        return "/root/sysrolepermission/view";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        return "/root/sysrolepermission/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(
            Model model,
            @ModelAttribute @Valid SysRolePermissionAddRequest entity,
            Errors errors) {

        String error_message = "";

        if (errors.hasErrors()) {
            List<ObjectError> objectErrorList = errors.getAllErrors();
            for (ObjectError objectError : objectErrorList) {
                error_message += objectError.toString();
            }
        }

        model.addAttribute("page_error", error_message);

        if (errors.hasErrors()) {

            return "/root/sysrolepermission/add";

        } else {

            return "redirect:/root/sysrolepermission/list";

        }
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del(
            Model model,
            @RequestParam(name = "id") Long id) {

        return "redirect:/root/sysrolepermission/list";
    }

    @RequestMapping(value = "/put", method = RequestMethod.GET)
    public String put(
            Model model,
            @RequestParam(name = "id") Long id) {

        model.addAttribute("page_data", null);

        return "/root/sysrolepermission/put";
    }

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public String put(
            Model model,
            @ModelAttribute @Valid SysRolePermissionPutRequest entity,
            Errors errors) {

        return "redirect:/root/sysrolepermission/list";
    }


}
