package com.bosssoft.gpmscloud.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;


@Table(name = "basic_region")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel("实体")
public class BasicRegion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 区划编码
     */
    @ApiModelProperty("区划编码")
    @Column(name = "REGION_CODE")
    private String regionCode;

    /**
     * 区划名称
     */
    @ApiModelProperty("区划名称")
    @Column(name = "REGION_NAME")
    private String regionName;

    /**
     * 父节点id
     */
    @ApiModelProperty("父节点id")
    @Column(name = "PARENT_ID")
    private String parentId;

    /**
     * 是否叶子节点
     */
    @ApiModelProperty("是否叶子节点")
    @Column(name = "IS_LEAF")
    private String isLeaf;

    /**
     * 区划级别
     */
    @ApiModelProperty("区划级别")
    @Column(name = "ZONE_LEVEL")
    private String zoneLevel;

    /**
     * 是否启用
     */
    @ApiModelProperty("是否启用")
    @Column(name = "ENABLED")
    private String enabled;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @Column(name = "REMARK")
    private String remark;

    /**
     * 加入已有库父节点区划编码
     */
    @ApiModelProperty("加入已有库父节点区划编码")
    @Column(name = "PARENT_ZONE_CODE")
    private String parentZoneCode;

    /**
     * 创建人名称
     */
    @ApiModelProperty("创建人名称")
    @Column(name = "CREATE_USER_NAME")
    private String createUserName;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 修改用户
     */
    @ApiModelProperty("修改用户")
    @Column(name = "UPDATE_USER_NAME")
    private String updateUserName;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 项目id前缀
     */
    @ApiModelProperty("项目id前缀")
    @Column(name = "PROJECT_ID_PREFIX")
    private String projectIdPrefix;

    /**
     * 区划全称（e.g. 市辖区 → 内蒙古自治区鄂尔多斯市市辖区）
     */
    @ApiModelProperty("区划全称（e.g. 市辖区 → 内蒙古自治区鄂尔多斯市市辖区）")
    @Column(name = "REGION_FULL_PATH")
    private String regionFullPath;

    @Override
    public String toString() {
        return "BasicRegion{" +
                "id='" + id + '\'' +
                "regionCode='" + regionCode + '\'' +
                "regionName='" + regionName + '\'' +
                ", userId='" + userId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", isLeaf='" + isLeaf + '\'' +
                ", zoneLevel='" + zoneLevel + '\'' +
                ", enabled=" + enabled +
                ", parentZoneCode='" + parentZoneCode + '\'' +
                ", regionFullPath='" + regionFullPath + '\'' +
                '}';
    }

    @Transient
    private String parentName;
}
