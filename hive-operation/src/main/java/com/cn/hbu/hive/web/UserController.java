package com.cn.hbu.hive.web;

import com.cn.hbu.hive.domain.User;
import com.cn.hbu.hive.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userList.do")
    @ResponseBody
    public List<User> selectAllUser(){
        List<User> userList = userService.selectAllUser();
        return userList;
    }

    @RequestMapping("/imgShow.do")
    @ResponseBody
    public Map<String,Object> imgShow(){

        List<User> userList = userService.selectAllUser();
        int i0 = 0;
        int i1 = 0;
        for (User user:userList){
            if (0 == user.getOrgtype()){
                i0 += 1 ;
            }else{
                i1 += 1;
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("count1",i1);
        map.put("count0",i0);
        map.put("dataList",userList);
        return map;
    }
}
