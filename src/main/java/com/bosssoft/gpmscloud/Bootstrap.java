package com.bosssoft.gpmscloud;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Description
 * @author: linjun
 * @date 2019/3/8 11:20
 */
@SpringBootApplication(scanBasePackages = {"com.bosssoft.gpmscloud"})
@EnableAsync
@EnableConfigurationProperties
@Slf4j
@EnableApolloConfig
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
        log.info("服务启动完成!");
    }
}
