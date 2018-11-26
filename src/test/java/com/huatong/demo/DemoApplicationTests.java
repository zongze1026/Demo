package com.huatong.demo;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.huatong.domain.User;
import com.huatong.mapper.UserMapper;
import com.huatong.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


//    @Autowired
//    private RoleService roleService;
    @Autowired
    private UserMapper userMapper;
//
//    @Test
//    public void add(){
//        RoleInfo roleInfo = new RoleInfo();
//        roleInfo.setRoleName("二哈");
//        roleInfo.setRoleLevel("2");
//        int i = roleService.addRole(roleInfo);
//        System.out.println(i);
//    }
//
//
//
//    @Test
//    public void get(){
//        PageInfo<RoleInfo> info = roleService.getRoleList();
//        System.out.println(info.getPages());
//        System.out.println(info.getTotal());
//        System.out.println(JSON.toJSONString(info.getList()));
//        System.out.println(info.getList().size());
//    }
//
//
//
//    @Test
//    public void annotation(){
//        roleService.mehtod();
//        roleService.mehtod2();
//    }

    @Test
    public void addUser(){
        User user = new User();
        user.setAge(18);
        user.setUserName("zhangsan");
        userMapper.add(user);
    }


    @Test
    public void find(){
        User user = userMapper.find();
        System.out.println(JSON.toJSONString(user));
    }









}
