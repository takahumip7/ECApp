package com.ec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// メールアドレスでユーザー取得（ログイン用）
	Optional<User> findByEmail(String email);
}
