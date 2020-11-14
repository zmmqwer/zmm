package com.zmm.ssm01.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: ssm01
 * @Package: com.zmm.ssm01.bean
 * @Description: java类作用描述
 * @Author: 周铭明
 * @CreateDate: 2020/11/13 0013 9:25
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class Test {
    public static void main(String[] args) {
        //获取当前时间
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stime = simpleDateFormat.format(date);
        System.out.println(stime);
    }
}
