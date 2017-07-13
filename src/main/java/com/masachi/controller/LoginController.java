package com.masachi.controller;

import com.masachi.dao.impl.UserDaoImpl;
import com.masachi.model.ResponseCode;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by masachi on 2017/7/13.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResponseCode login(@RequestBody String data){
        JSONObject object = JSONObject.fromObject(data);
        String username = object.getString("username");
        String password = object.getString("password");

        UserDaoImpl userDao = new UserDaoImpl();

        return userDao.findUserByName(username,password);
    }
}
