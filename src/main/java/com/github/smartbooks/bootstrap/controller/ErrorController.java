package com.github.smartbooks.bootstrap.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 统一的异常处理控制器
 */
@RequestMapping("/error")
@ControllerAdvice
public class ErrorController extends BaseController {

    @GetMapping("/index")
    @ExceptionHandler(Exception.class)
    public String index(Model model, Exception exception) {

        if (null != exception) {

            model.addAttribute("page_error", exception.getMessage());

        }

        return "/error/index";
    }

    /*

    @ExceptionHandler(TestException.class)
    public ResponseEntity<Object> error(TestException exception) {

        logger.trace(exception);

        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);

    }
    */

}
