package com.cg.RestfulService.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.cg.RestfulService.entity.User;

@Repository(value="inmemorydao") // Register this as a spring's bean
public class UserInMemoryRepository implements IDao {

	private static List<User> users = null;
	private static int userCount = 3;

	static {
		System.out.println("Inside static block of UserInMemoryRepository");

		users = new ArrayList<>();
		users.add(new User(10, "Amit", new Date()));
		users.add(new User(11, "Sumit", new Date()));
		users.add(new User(12, "Rahul", new Date()));
	}

	public UserInMemoryRepository() {
		System.out.println("Object of UserInMemoryRepository created using default constructor");
	}

	@Override
	public List<User> findAll() {
		System.out.println("Inside findAll() of UserInMemoryRepository");
		return users;
	}
	
	public Optional<User> findById(int id) {
		User user=users.stream().filter((t)->t.getId()==id).findAny().orElse(null);
		Optional<User> opt = Optional.ofNullable(user);
        return opt;
	}


	public User save(User user) {
		System.out.println("inside save() of In-Memory Repository");
//		user.setId(++(userCount));
		users.add(user);
		System.out.println("User added successfully");
		return user;
		
	}


	public User deleteById(int id) {
		// TODO Auto-generated method stub
		Iterator<User> iter = users.iterator();
		while (iter.hasNext()) {
			User u = iter.next();
			if (u.getId() == id) {
				iter.remove();
				return u;
			}
		}
		return null;
	}

	@Override
	public Optional<User> findByName(String username) {
		System.out.println("Inside findByName(String username) of UserInMemoryRepository");

		User user = users.stream().filter((User u) -> u.getName().equals(username)).findAny().orElse(null);
		Optional<User> opt = Optional.ofNullable(user);

		return opt;
	}

	

}
