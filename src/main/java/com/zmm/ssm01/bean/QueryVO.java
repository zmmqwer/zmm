package com.zmm.ssm01.bean;

/**
 * @ProjectName: ssm01
 * @Package: com.zmm.ssm01.bean
 * @Description: java类作用描述
 * @Author: 周铭明
 * @CreateDate: 2020/11/13 0013 11:45
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class QueryVO {
    private String tid;
    private String uid;
    private String otime;

    public String getOtime() {
        return otime;
    }

    public void setOtime(String otime) {
        this.otime = otime;
    }

    @Override
    public String toString() {
        return "QueryVO{" +
                "tid='" + tid + '\'' +
                ", uid='" + uid + '\'' +
                ", stime='" + otime + '\'' +
                '}';
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


}
