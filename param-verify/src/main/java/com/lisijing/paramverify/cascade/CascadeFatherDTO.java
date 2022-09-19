package com.lisijing.paramverify.cascade;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author 李健新
 * @Date 2022/9/19
 * @Description
 */
public class CascadeFatherDTO {

    @NotBlank(message = "姓名不可为空")
    private String name;

    /**
     * 子对象必须验证是否为空，当对象为null时不对子对象属性进行验证
     */
    @Valid
    @NotNull(message = "子对象不可为空")
    private CascadeChildDTO child;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CascadeChildDTO getChild() {
        return child;
    }

    public void setChild(CascadeChildDTO child) {
        this.child = child;
    }
}
