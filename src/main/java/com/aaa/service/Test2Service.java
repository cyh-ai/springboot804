package com.aaa.service;

import com.aaa.dao.Test2Dao;
import com.aaa.entity.Test2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Test2Service {

    @Resource
    private Test2Dao test2Dao;

    public List<Test2> listAll(){
        return test2Dao.selectAll();
    }
}
