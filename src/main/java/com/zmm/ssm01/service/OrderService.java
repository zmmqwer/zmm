package com.zmm.ssm01.service;

import com.zmm.ssm01.bean.QueryVO;
import com.zmm.ssm01.bean.User;

import java.util.List;

public interface OrderService {
    //购票
    void buy(String tid, String otime, String uid);

}
