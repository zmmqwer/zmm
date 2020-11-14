package com.zmm.ssm01.mapper;


import com.zmm.ssm01.bean.QueryVO;
import com.zmm.ssm01.bean.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询登录
    User login(User user);

    int buyTrainOK(QueryVO queryVO);

    List<Map<String, String>> selectBuy(String uid);
}