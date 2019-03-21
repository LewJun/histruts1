package com.microandroid.task.greet;

import com.microandroid.modules.emp.dto.Emp;
import com.microandroid.modules.emp.service.IEmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 定时任务案例
 *
 * @author LewJun
 * @version v0.1 2019/03/21 19:06 LewJun Exp $$
 */
public class TaskGreet {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskGreet.class);

    @Autowired
    private IEmpService<Emp> empService;

    void greet() {
        LOGGER.info("hi buddy ~ {}", empService);
    }
}
