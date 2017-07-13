package com.masachi.controller;

import com.masachi.dao.UserDao;
import com.masachi.dao.impl.UserDaoImpl;
import com.masachi.model.ResponseCode;
import com.masachi.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by masachi on 2017/7/13.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/index", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResponseCode index(@RequestBody String data){
        ResponseCode code = new ResponseCode();
        code.setCode(233);
        code.setMessage("233");
        return code;
    }
}
