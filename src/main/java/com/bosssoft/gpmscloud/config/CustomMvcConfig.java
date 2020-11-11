package com.bosssoft.gpmscloud.config;


import com.bosssoft.gpmscloud.security.oauth.client.config.ResourceMvcConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.util.List;


@Slf4j
@Configuration
public class CustomMvcConfig extends ResourceMvcConfig {


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);
        converters.add(0, new StringHttpMessageConverter());
    }
}
