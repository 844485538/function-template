package com.lisijing.sshutil.info;

import cn.hutool.system.oshi.OshiUtil;
import oshi.hardware.VirtualMemory;

/**
 * 内存相关工具类
 *
 *      物理内存和虚拟内存
 */
public class Memory {

    /**
     * 获取总内存
     *
     *  单位：byte
     * @return
     */
    public static long getTotal(){
        return OshiUtil.getMemory().getTotal();
    }

    /**
     * 获取可用内存总量
     *
     *   单位：byte
     * @return
     */
    public static long getAvailable(){
        return OshiUtil.getMemory().getAvailable();
    }

    /**
     * 获取系统内存页大小
     *
     *   单位：byte
     * @return
     */
    public static long getPageSize(){
        return OshiUtil.getMemory().getPageSize();
    }

    /**
     * 获取虚拟内存对象总大小
     *
     * @return
     */
    public static long getSwapTotal(){
        VirtualMemory virtualMemory = OshiUtil.getMemory().getVirtualMemory();
        return virtualMemory.getSwapTotal();
    }

    public static long getSwapUsed(){
        VirtualMemory virtualMemory = OshiUtil.getMemory().getVirtualMemory();
        return virtualMemory.getSwapUsed();
    }

    public static long getSwapPagesIn(){
        VirtualMemory virtualMemory = OshiUtil.getMemory().getVirtualMemory();
        return virtualMemory.getSwapPagesIn();
    }

    public static long getSwapPagesOut(){
        VirtualMemory virtualMemory = OshiUtil.getMemory().getVirtualMemory();
        return virtualMemory.getSwapPagesOut();
    }

    public static long getVirtualMax(){
        VirtualMemory virtualMemory = OshiUtil.getMemory().getVirtualMemory();
        return virtualMemory.getVirtualMax();
    }

    public static long getVirtualInUse(){
        VirtualMemory virtualMemory = OshiUtil.getMemory().getVirtualMemory();
        return virtualMemory.getVirtualInUse();
    }

}
