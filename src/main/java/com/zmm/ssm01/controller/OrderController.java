package com.zmm.ssm01.controller;

import com.zmm.ssm01.bean.Order;
import com.zmm.ssm01.bean.QueryVO;
import com.zmm.ssm01.bean.User;
import com.zmm.ssm01.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: ssm01
 * @Package: com.zmm.ssm01.controller
 * @Description: java类作用描述
 * @Author: 周铭明
 * @CreateDate: 2020/11/12 0012 20:46
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/buy")
    public String buy(HttpSession session, String tid, Model model){
        //获取当前时间
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String otime = simpleDateFormat.format(date);
        //获取之前用户登录存在session中的user
        User user = (User) session.getAttribute("user");
        //如果用户不为空说明已经登录了然后开始购票 并 返回主页面|
         orderService.buy(tid,otime,user.getUid());
         return "index";

    }

}
