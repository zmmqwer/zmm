
package com.zmm.ssm01.controller;

import com.zmm.ssm01.bean.QueryVO;
import com.zmm.ssm01.bean.User;
import com.zmm.ssm01.service.UserService;
import com.zmm.ssm01.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * @ProjectName: ssm01
 * @Package: com.zmm.ssm01.controller
 * @Description: java类作用描述
 * @Author: 周铭明
 * @CreateDate: 2020/11/12 0012 14:44
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */

@Controller
@SessionAttributes(value = "user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model,User user){
        User userOk=userService.login(user);
        if (userOk!=null){
            // 登录成功 将user信息放到session中
            model.addAttribute("user",userOk);
            //重定向首页
            return "forward:/index";
        }else {
            //转发到登录界面
            return "forward:/WEB-INF/jsp/login.jsp";
        }
    }

    //查询火车票是否被购买
    @RequestMapping("/buyTrainOK")
    public String buyTrainOK(QueryVO queryVO,HttpServletResponse response,HttpSession session) throws IOException {
        //判断是否登录


        User user = (User) session.getAttribute("user");

        //获取之前用户登录存在session中的user
        String[] split = queryVO.getTid().split(",");
        for (String s : split) {
            queryVO.setTid(s);
            if(user!=null){
                int result=userService.buyTrainOK(queryVO);
                if (result>0){
                    return "buyFail";
                }else {
                    return "redirect:buy?tid="+s;
                }
            }else {
                //转发到登录界面
                return "login";
            }
        }
        return null;
    }
    //查询购票
    @RequestMapping("/selectBuy")
    @ResponseBody
    public Object selectBuy(String uid){
        List<Map<String,String>> mapList=userService.selectBuy(uid);
        return mapList;
    }
    @RequestMapping("/loginOut")
    public String loginOut(Model model){
        model.addAttribute("user",null);
        return "login";
    }
}

