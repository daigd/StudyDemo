package com.dgd.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @author DaiGuodong
 * @create 2017-10-22-13:50
 * 自定义Realm
 */
public class MyRealm implements Realm {
    private static final String REALM_NAME = "myRealm";
    public String getName() {
        return REALM_NAME;
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        //只支持UsernamePasswordToken
        return authenticationToken instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //得到用户名
        String username = (String)authenticationToken.getPrincipal();
        //密码
        String password = new String((char[]) authenticationToken.getCredentials());
        if (!"zhang".equals(username)) {
            throw new AccountException();
        }
        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException();
        }
        //如果身份认证成功,返回AuthenticationInfo实现
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
