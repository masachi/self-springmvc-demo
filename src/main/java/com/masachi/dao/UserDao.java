package com.masachi.dao;

import com.masachi.model.ResponseCode;

import java.sql.SQLException;

/**
 * Created by masachi on 2017/7/13.
 */
public interface UserDao {
    public ResponseCode findUserByName(String name, String password);
}
