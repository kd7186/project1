package com.project1.example.service;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.project1.example.domain.User;
import com.project1.example.domain.UserInfo;

public interface UserService extends UserDetailsService{
	//유저읽기
	public User readUser(String username);
	
	//유저읽기 새로고침
	public UserInfo readUser_refresh(String username);
	
	public List<UserInfo>read_user_list();

	//유저생성
    public void createUser(User user);

	// 시큐리티 권한 얻기
	Collection<GrantedAuthority> getAuthorities(String username);

	// 권한 생성
	public void createAuthority(User user);
}
