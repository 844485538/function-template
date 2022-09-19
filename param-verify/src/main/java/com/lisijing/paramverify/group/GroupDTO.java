package com.lisijing.paramverify.group;

import com.lisijing.paramverify.group.identification.InsertGroup;
import com.lisijing.paramverify.group.identification.UpdateGroup;

import javax.validation.constraints.NotNull;

/**
 * @Author 李健新
 * @Date 2022/9/19
 * @Description
 */
public class GroupDTO {

    @NotNull(message = "insert操作时不可为空",groups = {InsertGroup.class})
    private String insert;

    @NotNull(message = "update操作时不可为空",groups = {UpdateGroup.class})
    private String update;

    public String getInsert() {
        return insert;
    }

    public void setInsert(String insert) {
        this.insert = insert;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }
}
