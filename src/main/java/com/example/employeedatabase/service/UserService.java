package com.example.employeedatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeedatabase.entity.UserEntity;
import com.example.employeedatabase.model.User;
import com.example.employeedatabase.repository.UserRepository;
import com.opertion.PasswordHashing;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	public List<User> getAllUsers() {

		try {
			List<UserEntity> users = userRepository.findAll();
			List<User> customusers = new ArrayList<>();
			users.stream().forEach(u -> {
				User user = new User();
				BeanUtils.copyProperties(u,user);
				customusers.add(user);
			});
			return customusers;
		} catch (Exception e) {
			throw e;
		}
	}
	public String addUser(UserEntity user) {
		try {
			if (!userRepository.existsByUserName(user.getUserName())) {
				user.setPassword(PasswordHashing.doHashing(user.getPassword()));
				System.out.println(user.getEmployee().getId());
				userRepository.save(user);
				return "User added successfully";
			}else {
				return "User Company already exists in the database.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public String removeUser(UserEntity user) {
		try {
			if (userRepository.existsByUserName(user.getUserName())) {
				userRepository.delete(user);
				return "User deleted successfully.";
			} else {
				return "User does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	public String updateUser(UserEntity user) {
		try {
			if (userRepository.existsById(user.getIdentity())) {
				userRepository.save(user);
				return "User updated successfully.";
			} else {
				return "User does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public User findByUserNameAndPassword(String userName,String password) {
		UserEntity user=userRepository.findByUserNameAndPassword(userName, PasswordHashing.doHashing(password));
		User usr =new User();
		BeanUtils.copyProperties(user,usr);
		return usr;
		
		
	}
}
