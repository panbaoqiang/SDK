package com.bosssoft.gpmscloud.component;

/**
 * 保存获取到apolloMetaServer地址
 */

final public class ApolloMetaUrlSetting {

    private ApolloMetaUrlSetting() {
    }

    public final static String apolloServerUrlField = "serverUrl";

    private static String serverUrl;

    public static String getServerUrl() {
        return serverUrl;
    }

    public static void setServerUrl(String serverUrl) {
        ApolloMetaUrlSetting.serverUrl = serverUrl;
    }
}
