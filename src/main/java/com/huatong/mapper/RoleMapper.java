package com.huatong.mapper;

import com.huatong.demo.RoleInfo;

import java.util.List;

/**
 * Create By xzz on 2018/11/9
 */
public interface RoleMapper {


    int insertRole(RoleInfo info);

    List<RoleInfo> getRoleList();
}
