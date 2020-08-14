package com.aaa.dao;

import com.aaa.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerDao {
    @Select("select * from Customer where cname = #{cname}")
    public Customer findbyCname(String cname);
}
