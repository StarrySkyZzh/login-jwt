package com.chilly.service;

import com.chilly.entity.User;


public interface UserService {
    /**
     * 登录接口
     *
     * @param user 表单中的user
     * @return 数据库中查询到的User
     */
    User login(User user);
}
