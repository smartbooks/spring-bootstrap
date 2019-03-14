package com.github.smartbooks.bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

/**
 * 管理主页
 * http://localhost:8080/home/index?language=[zh_CN|en_US]
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    /**
     * 国际化资源文件
     */
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/index")
    public String index(Model model, Locale locale) {

        model.addAttribute("msg", "HelloWorld");

        model.addAttribute("lang", messageSource.getMessage("welcome.text", null, locale));

        {
            List<HashMap<String, String>> urlList = new ArrayList<>();

            Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();

            for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
                HashMap<String, String> hashMap = new HashMap<>();
                RequestMappingInfo info = m.getKey();
                HandlerMethod method = m.getValue();
                PatternsRequestCondition p = info.getPatternsCondition();
                for (String url : p.getPatterns()) {
                    hashMap.put("url", url);
                }
                hashMap.put("className", method.getMethod().getDeclaringClass().getName()); // 类名
                hashMap.put("method", method.getMethod().getName()); // 方法名
                RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
                String type = methodsCondition.toString();
                if (type != null && type.startsWith("[") && type.endsWith("]")) {
                    type = type.substring(1, type.length() - 1);
                    hashMap.put("type", type); // 方法名
                }
                urlList.add(hashMap);
            }

            model.addAttribute("page_data", urlList);
        }

        return "/home/index";
    }

    @GetMapping("/error")
    public String error() throws Exception {
        throw new Exception("test Exception");
    }

}
