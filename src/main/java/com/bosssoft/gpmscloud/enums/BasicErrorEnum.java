package com.bosssoft.gpmscloud.enums;

import com.bosssoft.gpmscloud.common.core.enums.EnumValue;
import lombok.Getter;

/**
 * @Description
 * @author: linjun
 * @date 2019/3/20 17:51
 */
@Getter
public enum BasicErrorEnum implements EnumValue {
    USER_ORG_IS_NULL("user org is null", "用户单位表没有查询到数据！");


    BasicErrorEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;
}
