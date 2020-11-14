package com.zmm.ssm01.bean;

import java.io.Serializable;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * t_train
 * @author 
 */
@Data
@Table(name = "t_train")
public class Train implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer tid;

    private String tnumber;

    private String taddress;

    private String ttime;

    private String ttype;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Train{" +
                "tid=" + tid +
                ", tnumber='" + tnumber + '\'' +
                ", taddress='" + taddress + '\'' +
                ", ttime='" + ttime + '\'' +
                ", ttype='" + ttype + '\'' +
                '}';
    }
}