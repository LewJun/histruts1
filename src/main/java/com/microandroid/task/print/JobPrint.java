package com.microandroid.task.print;

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
public class JobPrint extends QuartzJobBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(JobPrint.class);

    private TaskPrint taskPrint;

    public void setTaskPrint(TaskPrint taskPrint) {
        this.taskPrint = taskPrint;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        taskPrint.print();
    }
}
