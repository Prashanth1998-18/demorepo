package com.cg.RestfulService.service;

import java.util.List;
import java.util.Optional;

import com.cg.RestfulService.entity.User;

public interface IService {

	public List<User> findAll();
	public User findOne(int id);
	public User save(User user);
	public void deleteOneUser(int id);
	public User findByName(String username);
}
