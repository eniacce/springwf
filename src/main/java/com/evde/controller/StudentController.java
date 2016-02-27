package com.evde.controller;

import com.evde.service.IStudentService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by mesut on 27.02.2016.
 */
@Controller
public class StudentController {
    @Autowired
    IStudentService transformService;


    @RequestMapping(value = "/firstPage")
    public String firstPage(ModelMap model) {


        System.out.println("System out is working");
        model.addAttribute("message", "Spring MVC JDBCTemplate welcome page");

        return "index";
    }

    @RequestMapping(value = "/databasetest")
    public @ResponseBody
    List<Map<String, Object>> databasetest() {

        return transformService.listStudent();
    }

    @RequestMapping(value = "/getSampleJSONData/{name}/{password}")
    public @ResponseBody String getSampleJSONData(@PathVariable String name, @PathVariable String password) {


        JSONObject jo = new JSONObject();
        jo.put("values", new JSONArray(new Long[][]{{1025409600000L,23L},{1028088000000L,19L},{1030766400000L,21L},{1033358400000L,22L}}));
        jo.put("key", "North America");

        JSONArray ja = new JSONArray();

        for (int i = 0; i < 10; i++) {
            ja.put(jo);
        }

        return ja.toString();
    }

}
