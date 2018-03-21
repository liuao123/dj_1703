package com.dj.springboot_mybits.controller;

import com.dj.springboot_mybits.pojo.Test01;
import com.dj.springboot_mybits.service.Test01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private Test01Service test01Service;

    //全表查
    @RequestMapping("testList")
    @ResponseBody
    public List<Test01> testList(){
        List<Test01> test01s = test01Service.testList();
        return test01s;
    }

    //id查询
    @RequestMapping("test01")
    @ResponseBody
    public Test01 test01 (Integer id){
        Test01 test01 = test01Service.test01(id);
        return test01;
    }


   /* @RequestMapping("updateTest")
    @ResponseBody
    public String updateTest(Test01 test01){
        Integer a = test01Service.updateTest(test01);
        if (a != 0){
            return "success";
        }
        return "defeated";
    }*/

    //    修改
    @RequestMapping("updateTest")
    @ResponseBody
    public String updateTest(){
        Test01 user = new Test01();
        user.setId(2);
        user.setName("la");
        user.setAge(21);
        Integer id = test01Service.updateTest(user);
        if (!StringUtils.isEmpty(id)){
            return "ok";
        }
        return "no";
    }

    //  增加
    @RequestMapping("addTest")
    @ResponseBody
    public String addTest(){
        Test01 user = new Test01();
        user.setName("hhhh");
        Integer id = test01Service.addTest(user);
        if (!StringUtils.isEmpty(id)){
            return "ok";
        }
        return "no";
    }


    //    根据id删除
    @RequestMapping("deleteTest")
    @ResponseBody
    public String deleteTest(Integer id){
        Integer idd = test01Service.deleteTest(id);
        if (!StringUtils.isEmpty(idd)){
            return "ok";
        }
        return "on";
    }

}
