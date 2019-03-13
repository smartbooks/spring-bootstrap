package com.github.smartbooks.bootstrap.scheduled;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 调度任务
 */
@Component
public class TestJob {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * 每秒钟调度一次
     */
    @Scheduled(cron = "* * * * * *")
    public void one() {

        logger.debug(String.format("TestJob.one - %s", System.currentTimeMillis()));

    }

}
