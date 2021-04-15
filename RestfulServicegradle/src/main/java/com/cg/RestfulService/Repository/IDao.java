package com.cg.RestfulService.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.RestfulService.entity.User;

public interface IDao  {

	public List<User> findAll();
	public Optional<User> findById(int id);
	public User save(User user);
	public User deleteById(int id);
	public Optional<User> findByName(String name);
}
