package com.bosssoft.gpmscloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 创建人：cherish
 * @version 版本号：V1.0
 * <p>
 * ***************************修订记录************************************
 * 2019-12-19 cherish 创建该类功能。
 * **********************************************************************
 * </p>
 * @ClassName 类名：ThreadPoolConfig
 * @Description 功能说明：任务线程池
 * <p>
 * TODO
 * </p>
 * **********************************************************************
 * @date 创建日期： 2019-12-19 cherish
 */
@Configuration
public class ThreadPoolConfig {

    @Bean("basicPlatformTaskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // 处理器的核心数
        int coreNum = Runtime.getRuntime().availableProcessors();
        // IO密集
        coreNum = coreNum * 2;
        taskExecutor.setCorePoolSize(coreNum);
        // 设置最大线程池线程数量为核心线程池的两倍
        int maxPoolSize = coreNum * 2;
        taskExecutor.setMaxPoolSize(coreNum);
        taskExecutor.setQueueCapacity(maxPoolSize);
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.setThreadNamePrefix("basicPlatformServerTask-");
        taskExecutor.initialize();
        return taskExecutor;
    }
}
