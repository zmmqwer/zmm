package com.zmm.ssm01.controller;

import com.zmm.ssm01.bean.Train;
import com.zmm.ssm01.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ssm01
 * @Package: com.zmm.ssm01.controller
 * @Description: java类作用描述
 * @Author: 周铭明
 * @CreateDate: 2020/11/12 0012 15:11
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class TrainController {
    @Autowired
    private TrainService trainService;
    //列表查询、
    @RequestMapping("/index")
    public String index(Model model, Train train){
        List<Train> trainList= trainService.list(train);

        //往前台传数据
        model.addAttribute("trainList",trainList);
        //model.addAttribute("trains",trains);
        //查询条件回写
        model.addAttribute("train",train);
        return "index";
    }
    //下拉列表框查询
    @RequestMapping("/queryBytid")
    public @ResponseBody List<Train> queryBytid(){
        return  trainService.queryBytid();
    }

}
