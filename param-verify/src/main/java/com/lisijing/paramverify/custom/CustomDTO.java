package com.lisijing.paramverify.custom;

import javax.validation.constraints.NotNull;

/**
 * @Author 李健新
 * @Date 2022/9/19
 * @Description
 */
public class CustomDTO {

    @NotNull()
    @ListValue(values = {0,1}, message = "必须为0或者1")
    private Integer showStatus;

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

}
