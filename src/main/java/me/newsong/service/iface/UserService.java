package me.newsong.service.iface;

import me.newsong.domain.User;

import java.util.List;

public interface UserService {
	User findById(Integer id);
	void addUser(User user);
	List<User> findByUsername(String username);
}
