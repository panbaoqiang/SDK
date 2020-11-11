package com.bosssoft.gpmscloud.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@ConfigurationProperties(prefix = "gpmscloud.swagger2")
@Configuration
public class Swagger2Properties {
    /**
     * 包
     */

    private String basePackage = "com.bosssoft.gpmscloud";
    /**
     * 标题
     */
    private String title = "gpmscloud-swagger2";
    /**
     * 备注
     */
    private String description = "政府采购项目api文档";
    /**
     * 版本
     */
    private String version = "1.0";

    private String termsOfServiceUrl;

}

