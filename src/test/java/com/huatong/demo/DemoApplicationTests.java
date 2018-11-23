package com.huatong.demo;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.huatong.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    private RoleService roleService;

    @Test
    public void add(){
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRoleName("二哈");
        roleInfo.setRoleLevel("2");
        int i = roleService.addRole(roleInfo);
        System.out.println(i);
    }



    @Test
    public void get(){
        PageInfo<RoleInfo> info = roleService.getRoleList();
        System.out.println(info.getPages());
        System.out.println(info.getTotal());
        System.out.println(JSON.toJSONString(info.getList()));
        System.out.println(info.getList().size());
    }



    @Test
    public void annotation(){
        roleService.mehtod();
        roleService.mehtod2();
    }









}
