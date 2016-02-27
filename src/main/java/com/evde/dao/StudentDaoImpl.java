package com.evde.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by mesut on 27.02.2016.
 */
public class StudentDaoImpl implements IStudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> listStudent() {
        String sql = "SELECT * FROM Student";
        List<Map<String, Object>> listOfPerson = jdbcTemplate.queryForList(sql);
        return listOfPerson;
    }
}
