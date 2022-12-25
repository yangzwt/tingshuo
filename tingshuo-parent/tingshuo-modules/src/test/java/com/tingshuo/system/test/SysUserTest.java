package com.tingshuo.system.test;

import com.tingshuo.system.entity.SysUserPo;
import com.tingshuo.system.mapper.SysUserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 类文件描述:
 *
 * @author yangzong
 * @version 1.0.0
 * @date 2021年12月12日 20:35
 **/
@SpringBootTest
//@RunWith(SpringRunner.class)
public class SysUserTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void test(){
        List<SysUserPo> sysUsers = sysUserMapper.selectList(null);
        Assert.assertEquals(2,sysUsers.size());
        sysUsers.forEach(System.out::println);
        System.out.printf("123456");
    }
}
