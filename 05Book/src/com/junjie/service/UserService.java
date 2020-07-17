package com.junjie.service;

import com.junjie.pojo.User;

/**
 * 业务层，一个业务一个方法
 * 如 登录是一个业务，注册也是一个业务等
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registerUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回null，说明登录失败，返回有值，是登录成功
     */
    public User login(User user);

    /**
     * 检查 用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);

}
