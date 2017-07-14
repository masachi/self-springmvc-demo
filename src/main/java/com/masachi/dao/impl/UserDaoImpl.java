package com.masachi.dao.impl;

import com.masachi.dao.UserDao;
import com.masachi.model.ResponseCode;
import com.masachi.model.User;
import com.masachi.model.UserEntity;
import com.masachi.service.LoginService;
import com.masachi.service.impl.LoginServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.masachi.config.DBConn;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.imageio.spi.ServiceRegistry;

/**
 * Created by masachi on 2017/7/13.
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;

    public ResponseCode findUserByName(String name, String password){
//        System.out.println("session:" + sessionFactory.getCurrentSession());
        ResponseCode code = new ResponseCode();
        LoginServiceImpl loginService = new LoginServiceImpl();

        if(loginService.string2MD5(password).equals(sessionFactory.getCurrentSession().get(UserEntity.class, name).getPassword())){
            code.setCode(200);
            code.setMessage("");
        }
        else{
            code.setCode(500);
            code.setMessage("Password Incorrect");
        }

        return code;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
