package com.example.employeedatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeedatabase.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	UserEntity findByUserNameAndPassword(String userName,String password);
	public boolean existsByUserName(String userName);
	public boolean existsById(int identity);

}
