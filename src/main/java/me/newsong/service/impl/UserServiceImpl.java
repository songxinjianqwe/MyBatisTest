package me.newsong.service.impl;

import javax.transaction.Transactional;

import me.newsong.dao.iface.UserRepository;
import me.newsong.exceptions.UsernameExistedException;
import me.newsong.service.iface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userDao;

	@Transactional
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Transactional
	public void addUser(User user)  {
		if (findByUsername(user.getUsername()) != null) {
			throw new UsernameExistedException(user.getUsername());
		}
		userDao.save(user);
	}
}
