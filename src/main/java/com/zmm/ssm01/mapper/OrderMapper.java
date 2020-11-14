package com.zmm.ssm01.mapper;


import com.zmm.ssm01.bean.QueryVO;
import com.zmm.ssm01.bean.User;

import java.util.List;

public interface OrderMapper {
    //购票
    void buy(QueryVO vo);


}