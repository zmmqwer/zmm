package com.zmm.ssm01.service;

import com.zmm.ssm01.bean.QueryVO;
import com.zmm.ssm01.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User login(User user);


    int buyTrainOK(QueryVO queryVO);

    List<Map<String, String>> selectBuy(String uid);
}
