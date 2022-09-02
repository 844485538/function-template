package com.lisijing.sshutil.info;

import cn.hutool.system.oshi.OshiUtil;

/**
 * Cpu信息
 */
public class Cpu {

    public static long getCpuNum(){
        return OshiUtil.getCpuInfo().getCpuNum();
    }

}
