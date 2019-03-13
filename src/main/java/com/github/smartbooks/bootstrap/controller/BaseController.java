package com.github.smartbooks.bootstrap.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Controller基类
 */
public abstract class BaseController {

    /**
     * 日志记录器
     */
    protected final Logger logger = LogManager.getLogger(this.getClass());

}
