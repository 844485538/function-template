package com.lisijing.paramverify.controller;

import com.lisijing.paramverify.base.BaseDTO;
import com.lisijing.paramverify.cascade.CascadeFatherDTO;
import com.lisijing.paramverify.cascade.ExtendChildDTO;
import com.lisijing.paramverify.config.ResponseTemplate;
import com.lisijing.paramverify.custom.CustomDTO;
import com.lisijing.paramverify.custom.size.CustomSizeDTO;
import com.lisijing.paramverify.group.GroupDTO;
import com.lisijing.paramverify.group.identification.InsertGroup;
import com.lisijing.paramverify.group.identification.UpdateGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @Author 李健新
 * @Date 2022/9/19
 * @Description
 */
@RestController
public class ParamController {

    /**
     * 基础单对象验证
     *
     * @param dto
     * @return
     */
    @RequestMapping("/base")
    @PostMapping
    public ResponseTemplate base(@Valid @RequestBody BaseDTO dto){
        return ResponseTemplate.success();
    }

    /**
     * 嵌套校验
     *
     * @param dto
     * @return
     */
    @RequestMapping("/cascade")
    @PostMapping
    public ResponseTemplate base(@Valid @RequestBody CascadeFatherDTO dto){
        return ResponseTemplate.success();
    }

    /**
     * 继承校验
     *
     * @param dto
     * @return
     */
    @RequestMapping("/extend")
    @PostMapping
    public ResponseTemplate extend(@Valid @RequestBody ExtendChildDTO dto){
        return ResponseTemplate.success();
    }

    /**
     * 分组校验
     *
     * @param dto
     * @return
     */
    @RequestMapping("/insert")
    @PostMapping
    public ResponseTemplate insert(@Validated({InsertGroup.class}) @RequestBody GroupDTO dto){
        return ResponseTemplate.success();
    }

    /**
     * 分组校验
     *
     * @param dto
     * @return
     */
    @RequestMapping("/update")
    @PostMapping
    public ResponseTemplate update(@Validated({UpdateGroup.class}) @RequestBody GroupDTO dto){
        return ResponseTemplate.success();
    }

    /**
     * 自定义校验
     *
     * @param dto
     * @return
     */
    @RequestMapping("/custom")
    @PostMapping
    public ResponseTemplate custom(@Valid @RequestBody CustomDTO dto){
        return ResponseTemplate.success();
    }

    /**
     * 自定义校验
     *
     * @param dto
     * @return
     */
    @RequestMapping("/customSize")
    @PostMapping
    public ResponseTemplate customSize(@Valid @RequestBody CustomSizeDTO dto){
        return ResponseTemplate.success();
    }

}
