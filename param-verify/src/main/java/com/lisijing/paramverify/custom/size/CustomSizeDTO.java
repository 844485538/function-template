package com.lisijing.paramverify.custom.size;

/**
 * @Author 李健新
 * @Date 2022/9/19
 * @Description
 */
public class CustomSizeDTO {

    @Size(min = 1, max = 2, message = "string 长度错误")
    private String sizeStr;

    @Size(min = 1, max = 2, message = "Integer 长度错误")
    private Integer sizeInteger;

    public String getSizeStr() {
        return sizeStr;
    }

    public void setSizeStr(String sizeStr) {
        this.sizeStr = sizeStr;
    }

    public Integer getSizeInteger() {
        return sizeInteger;
    }

    public void setSizeInteger(Integer sizeInteger) {
        this.sizeInteger = sizeInteger;
    }
}
