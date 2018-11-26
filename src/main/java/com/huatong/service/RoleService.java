package com.huatong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huatong.annotation.DynamicDatasource;
import com.huatong.demo.RoleInfo;
import com.huatong.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create By xzz on 2018/11/9
 */
@Service
public class RoleService {

//    @Autowired
//    private RoleMapper mapper;
//
//    @Transactional
//    public int addRole(RoleInfo info) {
//        int i = mapper.insertRole(info);
//        int n = 1 / 0;
//        return i;
//    }
//
//
//    public PageInfo<RoleInfo> getRoleList() {
//        PageHelper.startPage(1, 5);
//        List<RoleInfo> roleList = mapper.getRoleList();
//        PageInfo<RoleInfo> pageInfo = new PageInfo<>(roleList);
//        return pageInfo;
//    }
//
//
//    @DynamicDatasource
//    public void mehtod() {
//        System.out.println("method被调用了");
//    }
//
//
//    public void mehtod2() {
//        System.out.println("method2被调用了");
//    }


}
