package com.example.web.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.web.model.User;

@Mapper
public interface UserMapper {
	public User selectUserById(Integer id);
	public int insertUser(User user);
}
