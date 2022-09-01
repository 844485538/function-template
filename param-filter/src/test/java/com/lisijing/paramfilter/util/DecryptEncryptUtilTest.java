package com.lisijing.paramfilter.util;

import com.alibaba.fastjson.JSONObject;
import com.lisijing.paramfilter.entity.PersonVO;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DecryptEncryptUtilTest {

    private static final Logger LOG = LoggerFactory.getLogger(DecryptEncryptUtilTest.class);

    @Test
    public void decrypt(){
        PersonVO person = new PersonVO();
        person.setName("test");
        person.setAge(11);
        LOG.info(DecryptEncryptUtil.encrypt(JSONObject.toJSONString(person)));
    }

    @Test
    public void encrypt(){
        LOG.info(DecryptEncryptUtil.decrypt("51d93d1c436488e55e6318ff88a0f3cd"));
    }

}