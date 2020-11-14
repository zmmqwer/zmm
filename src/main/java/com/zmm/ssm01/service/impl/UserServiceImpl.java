package com.zmm.ssm01.service.impl;

import com.zmm.ssm01.bean.QueryVO;
import com.zmm.ssm01.bean.User;
import com.zmm.ssm01.mapper.UserMapper;
import com.zmm.ssm01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ssm01
 * @Package: com.zmm.ssm01.service.impl
 * @Description: java类作用描述
 * @Author: 周铭明
 * @CreateDate: 2020/11/12 0012 14:45
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
    //查询是否购买
    @Override
    public int buyTrainOK(QueryVO queryVO) {
        return userMapper.buyTrainOK(queryVO);
    }
    //查询购票信息
    @Override
    public List<Map<String, String>> selectBuy(String uid) {
        return userMapper.selectBuy(uid);
    }


}
