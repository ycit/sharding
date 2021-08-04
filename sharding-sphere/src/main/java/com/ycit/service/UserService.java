package com.ycit.service;

import com.ycit.bean.command.UserAddCommand;
import com.ycit.bean.entity.User;
import com.ycit.bean.entity.UserExample;
import com.ycit.dao.UserMapper;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author racy
 * @date 2021/8/1
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public void insert(UserAddCommand userAddCommand) {
        User user = from(userAddCommand);
        userMapper.insertSelective(user);
    }

    private User from(UserAddCommand userAddCommand) {
        User user = new User();
        BeanUtils.copyProperties(userAddCommand, user);
        return user;
    }

    public List<User> finds() {
//        HintManager hintManager = HintManager.getInstance();
//        hintManager.addDatabaseShardingValue("ss_user", 1);
//        hintManager.addTableShardingValue("ss_user", 1);
        UserExample userExample = new UserExample();
        List<User> users = userMapper.selectByExample(userExample);
//        hintManager.close();
        return users;
    }

}
