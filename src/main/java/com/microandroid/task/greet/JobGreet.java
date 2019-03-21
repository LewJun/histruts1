package com.microandroid.task.greet;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 定时任务案例
 *
 * @author LewJun
 * @version v0.1 2019/03/21 19:08 LewJun Exp $$
 */
public class JobGreet extends QuartzJobBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(JobGreet.class);

    private TaskGreet taskGreet;

    public void setTaskGreet(TaskGreet taskGreet) {
        this.taskGreet = taskGreet;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        taskGreet.greet();
    }
}
