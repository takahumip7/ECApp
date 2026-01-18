package com.ec.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ec.entity.User;
import com.ec.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	// ユーザー登録
	public void register(String name, String email, String password) {
		// TODO : email重複チェック
		if (userRepository.findByEmail(email).isPresent()) {
			throw new IllegalArgumentException("すでに登録されています。");
		}
		
		// TODO : passwordハッシュ化
		String hashed = passwordEncoder.encode(password);
		// TODO : user作成&保存
		User user = new User(name, email, hashed);
		
		userRepository.save(user);
	}

	//ログイン
	//ユーザー情報取得(ID)
}
