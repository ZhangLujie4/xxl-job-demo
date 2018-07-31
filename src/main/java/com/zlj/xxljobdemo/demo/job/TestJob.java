package com.zlj.xxljobdemo.demo.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author tori
 * 2018/7/31 上午11:17
 */

@Component
@JobHandler(value = "testJob")
public class TestJob extends IJobHandler {


    @Override
    public ReturnT<String> execute(String param) throws Exception {

        XxlJobLogger.log("调度任务开始");

        for (int i = 0; i < 5; i++) {
            XxlJobLogger.log("beat at:" + i);
            TimeUnit.SECONDS.sleep(2);
        }

        XxlJobLogger.log("调度任务结束");
        return SUCCESS;
    }
}
