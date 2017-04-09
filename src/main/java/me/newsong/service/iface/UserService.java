package me.newsong.service.iface;

import me.newsong.domain.User;

public interface UserService {
	User findById(Integer id);
	void addUser(User user);
}
