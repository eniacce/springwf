package com.evde.dao;

import com.evde.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by mesut on 28.02.2016.
 */
public class AddressDaoImpl implements IAddressDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Map<String, Object>> addressList() {
        String sql="SELECT * from Student s,description a where s.id =a.student_id";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
}
