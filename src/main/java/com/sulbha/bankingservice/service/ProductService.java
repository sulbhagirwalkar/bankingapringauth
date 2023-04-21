package com.sulbha.bankingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sulbha.bankingservice.entity.Product;
import com.sulbha.bankingservice.entity.UserInfo;
import com.sulbha.bankingservice.repository.UserInfoRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {

	List<Product> productList=null;
	
	
	@Autowired
	 private UserInfoRepository userInfoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void loadProductsFromDB() {
	
	}
	
	public List<Product> getProducts(){
		return productList;
	}
	
	public Product getProduct(long id) {
		return productList.stream()
				.filter(product->product.getProductId()==id)
				.findAny()
				.orElseThrow(()-> new RuntimeException("product "+id+" not found"));
	}

public String addUser(UserInfo userInfo) {
	userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));

	userInfoRepository .save(userInfo);
	return "user added to the system";
}
	
}
