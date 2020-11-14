package com.zmm.ssm01.service;

import com.zmm.ssm01.bean.Train;

import java.util.List;

/**
 * @ProjectName: ssm01
 * @Package: com.zmm.ssm01.service
 * @Description: java类作用描述
 * @Author: 周铭明
 * @CreateDate: 2020/11/12 0012 15:27
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface TrainService {
    List<Train> list(Train train);


    List<Train> queryBytid();
}
