package com.zmm.ssm01.service.impl;

import com.zmm.ssm01.bean.QueryVO;
import com.zmm.ssm01.bean.User;
import com.zmm.ssm01.mapper.OrderMapper;
import com.zmm.ssm01.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: ssm01
 * @Package: com.zmm.ssm01.service.impl
 * @Description: java类作用描述
 * @Author: 周铭明
 * @CreateDate: 2020/11/12 0012 20:47
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void buy(String tid, String otime, String uid) {
        QueryVO vo=new QueryVO();
        vo.setTid(tid);
        vo.setUid(uid);
        vo.setOtime(otime);
        orderMapper.buy(vo);
    }


}
