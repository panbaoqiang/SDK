package com.bosssoft.gpmscloud.controller;

import com.bosssoft.gpmscloud.common.core.response.RestResponse;
import com.bosssoft.gpmscloud.common.core.response.RestResponseBuilder;
import com.bosssoft.gpmscloud.config.IAppConfig;
import com.bosssoft.gpmscloud.config.IAppConfigClient;
import com.bosssoft.gpmscloud.config.models.BizConfValueMeta;
import com.bosssoft.gpmscloud.config.models.dto.ConfigParam;
import com.bosssoft.gpmscloud.pojo.validator.query;
import com.bosssoft.gpmscloud.pojo.vo.QueryConfigSdkVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author: panbaoqiang
 * @Date: 2020-9-20
 */
@RestController
@RequestMapping({"/business/config/"})
@Api(tags = "basic-业务配置查询")
@Slf4j
public class ConfigSdkController {

    @Autowired
    IAppConfigClient configClient;


    /**
     * 前端查询单配置接口
     *
     * @return
     */
    @ApiOperation(value = "前端获取单配置", notes = "前端获取单配置")
    @PostMapping("query/webConfig")
    public RestResponse<BizConfValueMeta> queryWebConfig(@RequestBody @Validated(value = query.class) QueryConfigSdkVo queryConfigSdkVo) {

        // group block key 暂时默认不传空值！
        ConfigParam configParam = ConfigParam.builder()
                .zoneCode(queryConfigSdkVo.getZoneCode())
                .orgId(queryConfigSdkVo.getOrgId())
                .group(queryConfigSdkVo.getGroup())
                .block(queryConfigSdkVo.getBlock())
                .key(queryConfigSdkVo.getKey())
                .web()
                .build();
        IAppConfig config = configClient.getConfig(configParam);
        if (null != config) {
            BizConfValueMeta prop = config.getWebProp(queryConfigSdkVo.getKey());
            return RestResponseBuilder.<BizConfValueMeta>builder().data(prop).build();
        }
        return RestResponseBuilder.<BizConfValueMeta>builder().data(null).build();
    }

    /**
     * 后端查询单配置接口
     *
     * @return
     */
    @ApiOperation(value = "获取后端单配置", notes = "获取后端单配置")
    @PostMapping("query/svrConfig")
    public RestResponse<BizConfValueMeta> queryServerConfig(@RequestBody @Validated(value = query.class) QueryConfigSdkVo queryConfigSdkVo) {
        // group block key 暂时默认不传空值！
        ConfigParam configParam = ConfigParam.builder()
                .zoneCode(queryConfigSdkVo.getZoneCode())
                .orgId(queryConfigSdkVo.getOrgId())
                .group(queryConfigSdkVo.getGroup())
                .block(queryConfigSdkVo.getBlock())
                .key(queryConfigSdkVo.getKey())
                .server()
                .build();
        IAppConfig config = configClient.getConfig(configParam);
        if (null != config) {
            BizConfValueMeta prop = config.getProp(queryConfigSdkVo.getKey());
            return RestResponseBuilder.<BizConfValueMeta>builder().data(prop).build();
        }
        return RestResponseBuilder.<BizConfValueMeta>builder().data(null).build();
    }

    /**
     * 查询单配置接口
     *
     * @return
     */
    @ApiOperation(value = "获取单配置", notes = "获取单配置")
    @PostMapping("query/mixedConfig")
    public RestResponse<Map<String, BizConfValueMeta>> queryMixedConfig(@RequestBody @Validated(value = query.class) QueryConfigSdkVo queryConfigSdkVo) {
        // group block key 暂时默认不传空值！
        ConfigParam configParam = ConfigParam.builder()
                .zoneCode(queryConfigSdkVo.getZoneCode())
                .orgId(queryConfigSdkVo.getOrgId())
                .group(queryConfigSdkVo.getGroup())
                .block(queryConfigSdkVo.getBlock())
                .key(queryConfigSdkVo.getKey())
                .build();
        IAppConfig config = configClient.getConfig(configParam);
        if (null != config) {
            BizConfValueMeta svrProp = config.getProp(queryConfigSdkVo.getKey());
            BizConfValueMeta webProp = config.getWebProp(queryConfigSdkVo.getKey());
            Map<String, BizConfValueMeta> results = new HashMap<>();
            results.put("server", svrProp);
            results.put("web", webProp);
            return RestResponseBuilder.<Map<String, BizConfValueMeta>>builder().data(results).build();
        }
        return RestResponseBuilder.<Map<String, BizConfValueMeta>>builder().data(null).build();
    }


    /**
     * 前端查询配置列表接口
     *
     * @return
     */
    @ApiOperation(value = "前端获取配置集合", notes = "前端获取配置集合")
    @PostMapping("query/webConfigList")
    public RestResponse<Map<String, BizConfValueMeta>> queryWebConfigs(@RequestBody QueryConfigSdkVo queryConfigSdkVo) {
        // group block key 可为空！
        ConfigParam configParam = ConfigParam.builder()
                .zoneCode(queryConfigSdkVo.getZoneCode())
                .orgId(queryConfigSdkVo.getOrgId())
                .group(queryConfigSdkVo.getGroup())
                .block(queryConfigSdkVo.getBlock())
                .key(queryConfigSdkVo.getKey())
                .web()
                .build();
        IAppConfig config = configClient.getConfig(configParam);
        if (null != config) {
            Map<String, BizConfValueMeta> webProps = config.listAllWebProps();
            return RestResponseBuilder.<Map<String, BizConfValueMeta>>builder().data(webProps).build();
        }
        return RestResponseBuilder.<Map<String, BizConfValueMeta>>builder().data(null).build();
    }


    /**
     * 后端查询配置列表接口
     *
     * @return
     */
    @ApiOperation(value = "获取后端配置列表", notes = "获取后端配置列表")
    @PostMapping("query/svrConfigList")
    public RestResponse<Map<String, BizConfValueMeta>> queryServerConfigs(@RequestBody QueryConfigSdkVo queryConfigSdkVo) {

        // group block key 暂时默认不传空值！
        ConfigParam configParam = ConfigParam.builder()
                .zoneCode(queryConfigSdkVo.getZoneCode())
                .orgId(queryConfigSdkVo.getOrgId())
                .group(queryConfigSdkVo.getGroup())
                .block(queryConfigSdkVo.getBlock())
                .key(queryConfigSdkVo.getKey())
                .server()
                .build();
        IAppConfig config = configClient.getConfig(configParam);
        if (null != config) {
            Map<String, BizConfValueMeta> svrProps = config.listAllProps();
            return RestResponseBuilder.<Map<String, BizConfValueMeta>>builder().data(svrProps).build();
        }
        return RestResponseBuilder.<Map<String, BizConfValueMeta>>builder().data(null).build();
    }

    /**
     * 查询配置列表接口
     *
     * @return
     */
    @ApiOperation(value = "获取配置列表", notes = "获取配置列表")
    @PostMapping("query/mixedConfigList")
    public RestResponse<Map<String, Map<String, BizConfValueMeta>>> queryMixedConfigs(@RequestBody QueryConfigSdkVo queryConfigSdkVo) {

        // group block key 暂时默认不传空值！
        ConfigParam configParam = ConfigParam.builder()
                .zoneCode(queryConfigSdkVo.getZoneCode())
                .orgId(queryConfigSdkVo.getOrgId())
                .group(queryConfigSdkVo.getGroup())
                .block(queryConfigSdkVo.getBlock())
                .key(queryConfigSdkVo.getKey())
                .build();
        IAppConfig config = configClient.getConfig(configParam);
        if (null != config) {
            Map<String, BizConfValueMeta> webProps = config.listAllWebProps();
            Map<String, BizConfValueMeta> svrProps = config.listAllProps();
            Map<String, Map<String, BizConfValueMeta>> results = new HashMap<>();
            results.put("server", svrProps);
            results.put("web", webProps);
            return RestResponseBuilder.<Map<String, Map<String, BizConfValueMeta>>>builder().data(results).build();
        }
        return RestResponseBuilder.<Map<String, Map<String, BizConfValueMeta>>>builder().data(null).build();
    }
}
