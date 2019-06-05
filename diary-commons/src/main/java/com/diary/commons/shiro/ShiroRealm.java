package com.diary.commons.shiro;

import java.util.Collection;
import java.util.HashSet;
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
import com.diary.dao.user.permission.mapper.PermissionMapper;
import com.diary.dao.user.permission.pojo.Permission;
import com.diary.dao.user.permission.pojo.PermissionExample;
import com.diary.dao.user.pojo.User;
import com.diary.dao.user.pojo.UserExample;
import com.diary.dao.user.pojo.UserExample.Criteria;
import com.diary.dao.user.role.mapper.RoleMapper;
import com.diary.dao.user.role.pojo.Role;
import com.diary.dao.user.role.pojo.RoleExample;
import com.diary.dao.user.rolepermissionassociation.mapper.RolePermissionMapper;
import com.diary.dao.user.rolepermissionassociation.pojo.RolePermission;
import com.diary.dao.user.rolepermissionassociation.pojo.RolePermissionExample;
import com.diary.dao.user.userroleassociation.mapper.UserRoleMapper;
import com.diary.dao.user.userroleassociation.pojo.UserRole;
import com.diary.dao.user.userroleassociation.pojo.UserRoleExample;

public class ShiroRealm extends AuthorizingRealm {
	
	/**
	 * 用户信息表操作
	 */
	@Autowired
    private UserMapper userMapper;
	
	/**
	 * 用户角色关联表操作
	 */
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	/**
	 * 角色信息表操作
	 */
	@Autowired
	private RoleMapper roleMapper;
	
	/**
	 * 角色权限关联表操作
	 */
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	
	/**
	 * 权限信息表操作
	 */
	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("正在分配用户角色和角色权限。。。。。。。。");
	    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
	    // 存储当前用户下的所有角色
	    HashSet<String> roleSet = new HashSet<String>();
	    // 存储当前角色下的所有权限
	    HashSet<String> permissionSet = new HashSet<String>();
	    // 获取用户信息
	    User userInfo  = (User)principals.getPrimaryPrincipal();
	    // 获取用户角色id
	    String userRoleId = getUserRoleId(userInfo.getUserId());
	    // 获取用户角色信息
	    List<Role> roles = getUserRoleInfo(userRoleId);
	    // 获取所有角色
	    for (Role role : roles) {
	    	// 角色是否启用
	    	if (role.getState() == 1) {
	    		roleSet.add(role.getName());
			}
		}
	    // 角色分配
	    authorizationInfo.addRoles(roleSet);
	    // 获取角色权限id
	    String rolePermissionId = getRolePermissionId(userRoleId);
	    // 获取权限信息
	    List<Permission> permissions = getRolePermissionInfo(rolePermissionId);
	    // 获取所有权限
	    for (Permission permission : permissions) {
	    	// 权限是否启用
			if (permission.getStatus() == 1) {
				permissionSet.add(permission.getName());
			}
		}
	    // 权限分配
	    authorizationInfo.addStringPermissions(permissionSet);
	    return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		System.out.println("正在进行用户身份认证。。。。。。。");
		//获取用户信息
        String account = authenticationToken.getPrincipal().toString();
        // 自定义查询条件
        UserExample userExample = new UserExample();
        Criteria userCriteria = userExample.createCriteria();
        userCriteria.andAccountEqualTo(account);
        // 查询当前账号用户信息
        List<User> users = userMapper.selectByExample(userExample);
        User user = users.get(0);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getAccount(), user.getPassword());
		return info;
	}
	
	/**
	 * 获取用户角色id
	 * @param userId 用户id
	 * @return 用户角色id
	 */
	private String getUserRoleId(String userId) {
		UserRoleExample userRoleExample = new UserRoleExample();
        com.diary.dao.user.userroleassociation.pojo.UserRoleExample.Criteria userRoleCriteria = userRoleExample.createCriteria();
        userRoleCriteria.andUserIdEqualTo(userId);
        List<UserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);
        UserRole userRole = userRoles.get(0);
        System.out.println("当前用户ID："+userRole.getRoleId());
        return userRole.getRoleId();
	}
	
	/**
	 * 获取当前用户所有角色信息
	 * @param roleId 用户角色id
	 * @return 用户角色信息
	 */
	private List<Role> getUserRoleInfo(String roleId) {
		RoleExample roleExample = new RoleExample();
		com.diary.dao.user.role.pojo.RoleExample.Criteria criteria = roleExample.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		List<Role> roles = roleMapper.selectByExample(roleExample);
		return roles;
	}
	
	/**
	 * 获取当前角色权限id
	 * * @param roleId 用户角色id
	 * @return 角色权限id
	 */
	private String getRolePermissionId(String roleId) {
		RolePermissionExample rolePermissionExample = new RolePermissionExample();
		com.diary.dao.user.rolepermissionassociation.pojo.RolePermissionExample.Criteria criteria = rolePermissionExample.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		List<RolePermission> rolePermissions = rolePermissionMapper.selectByExample(rolePermissionExample);
		RolePermission rolePermission = rolePermissions.get(0);
		return rolePermission.getPermissionId();
	}
	
	/**
	 * 获取当前角色下的所有权限信息
	 */
	private List<Permission> getRolePermissionInfo(String permissionId) {
		PermissionExample permissionExample = new PermissionExample();
		com.diary.dao.user.permission.pojo.PermissionExample.Criteria criteria= permissionExample.createCriteria();
		criteria.andPermissionIdEqualTo(permissionId);
		List<Permission> permissions = permissionMapper.selectByExample(permissionExample);
		return permissions;
	}

}
