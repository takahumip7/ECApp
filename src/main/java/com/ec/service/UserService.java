package com.ec.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ec.dto.UserLoginRequest;
import com.ec.dto.UserLoginResponse;
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
	public UserLoginResponse login(UserLoginRequest loginDto) {
		// emailでユーザーを取得
		User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(() -> new IllegalArgumentException("USER_NOT_FOUND"));
		
		// パスワードチェック(rawとhashの比較)
		if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
			throw new IllegalArgumentException("PASSWORD_INCORRECT");
		}
		
		// ログイン成功→レスポンスDTOを返す
		return new UserLoginResponse(user.getId(), user.getName(),user.getEmail());
	}
	//ユーザー情報取得(ID)
}
