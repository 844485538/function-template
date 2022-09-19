package com.lisijing.paramverify.cascade;

import javax.validation.constraints.NotBlank;

/**
 * @Author 李健新
 * @Date 2022/9/19
 * @Description
 */
public class ExtendFatherDTO {

    @NotBlank(message = "姓名不可为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
