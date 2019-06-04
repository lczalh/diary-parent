package com.diary.commons.shiro;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.diary.dao.user.mapper.UserMapper;
import com.diary.dao.user.pojo.User;
import com.diary.dao.user.pojo.UserExample;
import com.diary.dao.user.pojo.UserExample.Criteria;

public class DiaryRealm extends AuthorizingRealm {
	
	@Autowired
    private UserMapper userMapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
	    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
	    // 获取用户信息
	    User userInfo  = (User)principals.getPrimaryPrincipal();
	    System.out.println(userInfo.getAccount());
	    // 设置角色
	    authorizationInfo.addRole("admin");

	    return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		System.out.println("————身份认证方法————");
		//获取用户信息
        String account = authenticationToken.getPrincipal().toString();
        // 自定义查询条件
        UserExample userExample = new UserExample();
        Criteria criteria = userExample.createCriteria();
        criteria.andAccountEqualTo(account);
        // 查询当前账号用户信息
        List<User> users = userMapper.selectByExample(userExample);
        User user = users.get(0);
        // 查询用户权限 
		System.out.println("获取角色信息22222："+ user.getAccount());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getAccount(), user.getPassword());
		return info;
	}


}
