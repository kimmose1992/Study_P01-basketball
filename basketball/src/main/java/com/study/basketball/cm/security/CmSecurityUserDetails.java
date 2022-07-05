package com.study.basketball.cm.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Setter;

/**
 * @title	: Spring Security UserDetails 구현 클래스
 * @author	: 김모세
 * @create	: 2022.07.05
 */
@Setter
public class CmSecurityUserDetails implements UserDetails {

	private Collection<? extends GrantedAuthority> authorities;
    private String username;
    private String password;
    
	/**
	 * [UserDetails] 
	 * 인증된 사용자 정보를 담는 인터페이스
	 * 
	 * [method]
	 * 권한목록  	:: getAuthorities()
	 * 계정만료여부	:: isAccountNonExpired() 
	 * 계정잠금여부	:: isAccountNonLocked() 
	 * 암호만료여부	:: isCredentialsNonExpired() 
	 * 활성화여부	:: isEnabled() 
	 */
	private static final long serialVersionUID = -5761971624690110484L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
