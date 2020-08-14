package com.aaa.entity;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class Test2 {
    @Id
    private Integer tid;
    private String tname;
    private String pwd;
    private Integer sex;
    private String idcard;
    private String phone;
    private Date times;
}
