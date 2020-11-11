package com.bosssoft.gpmscloud.component.listener;

import com.bosssoft.gpmscloud.config.IBizConfigService;
import com.ctrip.framework.apollo.build.ApolloInjector;
import com.ctrip.framework.apollo.util.ConfigUtil;
import com.google.common.base.Strings;
import com.bosssoft.gpmscloud.component.ApolloMetaUrlSetting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Slf4j
@Component
@ConditionalOnProperty(prefix = "gpx.config.client", name = "type", havingValue = "apollo")
public class ApolloConfigMetaListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private IBizConfigService<String> apolloConfigService;

    private ConfigUtil configUtil = ApolloInjector.getInstance(ConfigUtil.class);

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        String apolloMetaServerUrl = configUtil.getMetaServerDomainName();
        if (!Strings.isNullOrEmpty(apolloMetaServerUrl)) {
            ApolloMetaUrlSetting.setServerUrl(apolloMetaServerUrl);
            try {
                Class<?> clazz = apolloConfigService.getClass();
                //获取apollo ConfigService的serverUrl字段
                Field declaredField = clazz.getDeclaredField(ApolloMetaUrlSetting.apolloServerUrlField);
                declaredField.setAccessible(true);
                //设置apollo地址为实际部署的环境
                declaredField.set(apolloConfigService, apolloMetaServerUrl);
                log.info("初始化更新apolloConfigService的serverUrl为:{}", apolloMetaServerUrl);
            } catch (Exception e) {
                log.error("初始化更新apolloConfigService的serverUrl失败，" + e.getMessage(), e);
            }
        }
    }
}
