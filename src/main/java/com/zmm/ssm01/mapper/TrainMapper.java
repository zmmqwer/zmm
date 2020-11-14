package com.zmm.ssm01.mapper;

import com.zmm.ssm01.bean.Train;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TrainMapper extends Mapper<Train> {

    List<Train> list(Train train);

    /*List<Train> queryBytnumber(String tnumber);*/
}