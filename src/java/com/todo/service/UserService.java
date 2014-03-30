package com.todo.service;

import com.todo.mapper.UserMapper;
import com.todo.model.User;
import com.todo.util.MdImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author caoxin
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void addUser(User user) {
        if (user == null) {
            return;
        }
        user.setPasswd(MdImplement.encodeMD5To32(user.getPasswd().getBytes()));
        this.userMapper.insertUser(user);
    }

    public void updateUser(User user) {
        if (user == null) {
            return;
        }
        this.userMapper.updateUser(user);
    }

    public User getUser(String account) {
        if (account == null || account.isEmpty()) {
            return null;
        }
        return userMapper.selectUser(account);
    }
}