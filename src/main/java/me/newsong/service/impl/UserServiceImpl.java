package me.newsong.service.impl;

import me.newsong.dao.UserMapper;
import me.newsong.domain.User;
import me.newsong.service.iface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;
    
    @Transactional
	public User findById(Integer id){
	    return userDao.selectByPrimaryKey(id);
    }

	@Transactional
	public void addUser(User user)  {
		userDao.insert(user);
	}
}
