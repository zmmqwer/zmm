package com.zmm.ssm01.service.impl;

import com.zmm.ssm01.bean.Train;
import com.zmm.ssm01.mapper.TrainMapper;
import com.zmm.ssm01.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: ssm01
 * @Package: com.zmm.ssm01.service.impl
 * @Description: java类作用描述
 * @Author: 周铭明
 * @CreateDate: 2020/11/12 0012 15:27
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service("trainService")
public class TrainServiceImpl implements TrainService  {
    @Autowired
    private TrainMapper trainMapper;

    @Override
    public List<Train> list(Train train) {
        return trainMapper.list(train);
    }
    //下拉列表框查询
    @Override
    public List<Train> queryBytid() {
        return trainMapper.selectAll();
    }


}
