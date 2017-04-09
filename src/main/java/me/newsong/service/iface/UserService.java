package me.newsong.service.iface;

public interface UserService {
	User findByUsername(String username);
	void addUser(User user);
}
