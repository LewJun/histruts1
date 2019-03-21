package com.microandroid.task.print;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定时任务案例
 *
 * @author LewJun
 * @version v0.1 2019/03/21 19:06 LewJun Exp $$
 */
public class TaskPrint {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskPrint.class);

    void print() {
        LOGGER.info("Struts + Spring + Quartz integration example ~");
    }
}
