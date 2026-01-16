package com.ec.service;

import org.springframework.stereotype.Service;

import com.ec.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// ユーザー登録
	public void register(String name, String email, String password) {
		// TODO : email重複チェック
		// TODO : passwordハッシュ化
		// TODO : user作成&保存
	}

	//ログイン
	//ユーザー情報取得(ID)
}
