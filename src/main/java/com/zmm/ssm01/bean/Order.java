package com.zmm.ssm01.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * t_order
 * @author 
 */
public class Order implements Serializable {
    private Integer oid;

    private Date otime;

    private Integer uid;
    private Integer tid;

    public Integer getTid() {
        return tid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", otime=" + otime +
                ", uid=" + uid +
                ", tid=" + tid +
                '}';
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    private static final long serialVersionUID = 1L;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}