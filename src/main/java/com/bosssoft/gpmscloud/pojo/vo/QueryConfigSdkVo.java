package com.bosssoft.gpmscloud.pojo.vo;


import com.bosssoft.gpmscloud.pojo.validator.query;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class QueryConfigSdkVo {
    @ApiModelProperty("区划")
    @NotBlank(message = "区划为空", groups = {query.class})
    private String zoneCode;

    @ApiModelProperty("机构")
    @NotBlank(message = "机构为空", groups = {query.class})
    private String orgId;

    @ApiModelProperty("配置分组")
    @NotBlank(message = "配置分组为空", groups = {query.class})
    private String group;


    @ApiModelProperty("配置块")
    @NotBlank(message = "配置分块为空", groups = {query.class})
    private String block;

    @ApiModelProperty("配置key")
    @NotBlank(message = "配置key为空", groups = {query.class})
    private String key;

}
