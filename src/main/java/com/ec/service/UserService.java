package com.ec.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ec.dto.UserRegisterRequest;
import com.ec.dto.UserRegisterResponse;
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
	public UserRegisterResponse register(UserRegisterRequest dto) {
		// email重複チェック
		if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
			throw new IllegalArgumentException("EMAIL_ALREADY_EXISTS");
		}
		
		// passwordハッシュ化
		String hashed = passwordEncoder.encode(dto.getPassword());
		
		// userのentity作成
		
		User user = new User(dto.getName(), dto.getEmail(), hashed);
		// 保存
		User savedUser = userRepository.save(user);
		
		// response用DTOに変換して返す
		return new UserRegisterResponse(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
	}

	//ログイン
	//ユーザー情報取得(ID)
}
