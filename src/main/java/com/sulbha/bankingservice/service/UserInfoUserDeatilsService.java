package com.sulbha.bankingservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sulbha.bankingservice.config.UserInfoUserDetails;
import com.sulbha.bankingservice.entity.UserInfo;
import com.sulbha.bankingservice.repository.UserInfoRepository;

@Component
public class UserInfoUserDeatilsService implements UserDetailsService {
	
	@Autowired
	private UserInfoRepository userInforRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
				Optional<UserInfo> userInfo=userInforRepository.findByName(username);
				
			return userInfo.map(UserInfoUserDetails::new)
				.orElseThrow(()->new UsernameNotFoundException("User not found"+username));
		
		
	}

}
