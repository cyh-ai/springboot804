package com.aaa.controller;

import com.aaa.entity.Test2;
import com.aaa.service.Test2Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("test")
public class Test2Controller {
    @Resource
    private Test2Service test2Service;

    @RequestMapping("selectAll")
    public String selectAll(Model model){
        List<Test2> list = test2Service.listAll();
        model.addAttribute("list",list);
        return "course";
    }
}
