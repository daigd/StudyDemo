package com.dgd.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author DaiGuodong
 * @create 2017-10-22-13:31
 * shiro示例
 */
public class demo {
    @Test
    public void test() {
        login("classpath:shiro.ini", "zhang", "123");
        Subject subject = SecurityUtils.getSubject();

        subject.hasRole("admin");
        //断言是否拥有admin角色
        Assert.assertEquals(true,subject.hasRole("admin"));
        //subject.hasAllRoles(Arrays.asList("admin", "master"));
        //断言拥有的角色集合
        Assert.assertEquals(true,subject.hasAllRoles(Arrays.asList("admin", "master")));
    }

    private void login(String config,String username,String password) {
        //1,获取SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(config);
        //2,获取SecurityManager实例并绑定到SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3,得到当前用户
        Subject subject = SecurityUtils.getSubject();
        //4,设置用户名密码
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            //5,尝试登录
            subject.login(token);
        } catch (AuthenticationException exception) {
            //身份验证失败
        }
        //6,断言登录成功
        //Assert.assertEquals(true, subject.isAuthenticated());

        //Assert.assertEquals(false,subject.hasRole("admin"));
        //7,退出
        //subject.logout();
    }
}
