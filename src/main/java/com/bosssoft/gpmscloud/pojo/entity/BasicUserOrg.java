package com.bosssoft.gpmscloud.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * @author ldj
 * @email 347544774@qq.com
 * @date 2019-04-10 11:48:25
 */
@Getter
@Setter
@ApiModel("")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "basic_user_org")
public class BasicUserOrg implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 人员ID
     */
    @ApiModelProperty("人员ID")
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 单位ID
     */
    @ApiModelProperty("单位ID")
    @Column(name = "ORG_ID")
    private String orgId;

    /**
     * 单位名称
     */
    @ApiModelProperty("单位名称")
    @Column(name = "ORG_NAME")
    private String orgName;

    /**
     * 角色类型
     */
    @ApiModelProperty("角色类型")
    @Column(name = "USER_TYPE")
    private Integer userType;

    /**
     * 区划编码
     */
    @ApiModelProperty("区划编码")
    @Column(name = "ZONE_CODE")
    private String zoneCode;

    /**
     * 区划名称
     */
    @ApiModelProperty("区划名称")
    @Column(name = "ZONE_NAME")
    private String zoneName;

    /**
     * 是否是管理员
     */
    @ApiModelProperty("是否是管理员")
    @Column(name = "ADMINISTRATOR")
    private String administrator;

    @Override
    public String toString() {
        return "BasicUserOrg{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", userType=" + userType +
                ", zoneCode='" + zoneCode + '\'' +
                ", zoneName='" + zoneName + '\'' +
                ", administrator='" + administrator + '\'' +
                '}';
    }

    @Transient
    @ApiModelProperty("单位下的人员")
    private List<BasicUserOrg> children;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
