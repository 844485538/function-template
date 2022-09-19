package com.lisijing.paramverify.cascade;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @Author 李健新
 * @Date 2022/9/19
 * @Description
 */
@Valid
public class CascadeChildDTO {

    @NotBlank(message = "地址不可为空")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
