package com.evde.service;

import com.evde.dao.IStudentDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by mesut on 27.02.2016.
 */
public class StudentServiceImpl implements IStudentService {
   @Autowired
    IStudentDao studentDao;
    public List<Map<String, Object>> listStudent() {
        return studentDao.listStudent();
    }
}
