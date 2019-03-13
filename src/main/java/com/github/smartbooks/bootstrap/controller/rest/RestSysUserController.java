package com.github.smartbooks.bootstrap.controller.rest;

import com.github.smartbooks.bootstrap.dao.entity.SysUser;
import com.github.smartbooks.bootstrap.service.SysUserService;
import com.github.smartbooks.bootstrap.util.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 跨域访问,只在当前Controller生效
 */
@CrossOrigin(origins = "baidu.com")
@RestController
public class RestSysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/user")
    public ResponseEntity<Object> list() {

        return new ResponseEntity<>(sysUserService.list(new Paging()), HttpStatus.OK);

    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> put(@PathVariable("id") String id, @RequestBody SysUser product) {

        sysUserService.update(0L, product);

        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);

    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {

        sysUserService.delete(0L);

        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Object> post(@RequestBody SysUser product) {

        sysUserService.create(product);

        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

}
