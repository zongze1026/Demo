package com.huatong.mapper;

import com.huatong.annotation.DynamicDatasource;
import com.huatong.domain.User;


/**
 * Create By xzz on 2018/11/9
 */
public interface UserMapper {


    @DynamicDatasource("master")
    int add(User user);

    @DynamicDatasource("slave")
    User find();

    @DynamicDatasource("slave02")
    int addUser(User user);


}
