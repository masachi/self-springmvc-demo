package com.masachi.dao.impl;

import com.masachi.dao.UserDao;
import com.masachi.model.ResponseCode;
import com.masachi.model.User;
import com.masachi.service.LoginService;
import com.masachi.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.masachi.config.DBConn;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by masachi on 2017/7/13.
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ResponseCode findUserByName(String name, final String password){
        final ResponseCode code = new ResponseCode();
        final LoginServiceImpl loginService = new LoginServiceImpl();

//        try {
//            Statement selectUser = DBConn.connection.createStatement();
//
//            String sql = "select * from user where username = " + name;
//
//            ResultSet resultSet = selectUser.executeQuery(sql);
//            if (resultSet.next()) {
//                if (resultSet.getString("password").equals(loginService.string2MD5(password))) {
//                    code.setCode(200);
//                    code.setMessage("");
//                } else {
//                    code.setCode(500);
//                    code.setMessage("Password Incorrect");
//                }
//            } else {
//                code.setCode(500);
//                code.setMessage("No Such User");
//            }
//        }
//        catch (Exception e){
//            code.setCode(500);
//            code.setMessage("Server Error");
//        }
        String sql = "select * from user where username = " + name;
        jdbcTemplate.query(sql, new Object[]{name, password}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                if (resultSet.next()) {
                    if (resultSet.getString("password").equals(loginService.string2MD5(password))) {
                        code.setCode(200);
                        code.setMessage("");
                    } else {
                        code.setCode(500);
                        code.setMessage("Password Incorrect");
                    }
                } else {
                    code.setCode(500);
                    code.setMessage("No Such User");
                }
            }
        });
        return code;
    }
}
