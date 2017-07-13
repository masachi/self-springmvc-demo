package com.masachi.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by masachi on 2017/7/13.
 */
@Repository("jdbcDataDAO")
public class JdbcDataDAOImpl extends JdbcDaoSupport {
    private JdbcTemplate jdbcTemplate;

    public String select(List<String> params, String table) throws SQLException{
        return "success";
    }
}
