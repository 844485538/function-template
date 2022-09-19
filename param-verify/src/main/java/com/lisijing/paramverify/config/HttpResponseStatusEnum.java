package com.lisijing.paramverify.config;

/**
 * @Author 李健新
 * @Date 2022/5/6
 * @Description
 *
 *   HTTP返回值状态
 */
public enum HttpResponseStatusEnum {

    /**
     * 成功
     */
    SUCCESS("SUCCESS",6200),

    /**
     * 失败
     */
    FAIL("FAIL",6500),

    /**
     * 业务异常
     */
    PARAM_ERROR("PARAM ERROR",6501);

    private String description;

    private Integer code;

    private HttpResponseStatusEnum(String description, Integer code) {
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    void setCode(Integer code) {
        this.code = code;
    }

}
