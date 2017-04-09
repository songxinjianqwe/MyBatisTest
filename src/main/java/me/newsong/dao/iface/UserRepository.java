package me.newsong.dao.iface;


public interface UserRepository{
	User findByUsername(String username);
    void save(User user);
}
