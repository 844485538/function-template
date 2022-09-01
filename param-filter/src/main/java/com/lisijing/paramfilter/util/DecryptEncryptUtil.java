package com.lisijing.paramfilter.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 加密解密工具类
 */
public class DecryptEncryptUtil {

    private static final Logger LOG = LoggerFactory.getLogger(DecryptEncryptUtil.class);

    private static final SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, "9cgO5zFEGraQLRjktmb8vg==".getBytes());

    private static void generateKey(){
        //随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        LOG.info(JSONObject.toJSONString(key));
    }

    /**
     * 加密
     * @param content
     * @return
     */
    public static String encrypt(String content){
        //加密
        String encryptHex = aes.encryptHex(content);
        return encryptHex;
    }

    /**
     * 解密
     * @param content
     * @return
     */
    public static String decrypt(String content){
        //解密
        return aes.decryptStr(content, CharsetUtil.CHARSET_UTF_8);
    }

}
