package com.lisijing.paramverify.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author Li Jianxin
 * @JSONType 设置序列化时属性顺序
 *
 * 		HTTP返回结果实体类
 */
@JSONType(orders = { "code", "message", "data"})
public class ResponseTemplate {

	/**
	 * 状态码
	 */
	private Integer code;

	/**
	 * 信息
	 */
	private String message;

	/**
	 * 数据
	 */
	private Object data;

	private ResponseTemplate(Integer code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * 成功 - 无返回
	 *
	 * @return
	 */
	public static ResponseTemplate success() {
		return new ResponseTemplate(HttpResponseStatusEnum.SUCCESS.getCode(), "success", null);
	}

	/**
	 * 成功 - 无返回
	 *
	 * @return
	 */
	public static ResponseTemplate fail() {
		return new ResponseTemplate(HttpResponseStatusEnum.FAIL.getCode(), "fail", null);
	}


	/**
	 * 参数校验异常
	 * @param msg
	 * @return
	 */
	public static ResponseTemplate paramErrorException(String msg) {
		return new ResponseTemplate(HttpResponseStatusEnum.PARAM_ERROR.getCode(), msg, null);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}


