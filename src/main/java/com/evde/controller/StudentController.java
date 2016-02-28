package com.evde.controller;

import com.evde.model.Student;
import com.evde.service.IAddress;
import com.evde.service.IStudentService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by mesut on 27.02.2016.
 */
@Controller
public class StudentController {
    @Autowired
    IStudentService transformService;
    @Autowired
    IAddress address;

    @RequestMapping(value = "/firstPage")
    public String firstPage(ModelMap model) {

        System.out.println("System out is working");
        model.addAttribute("message", "Spring MVC JDBCTemplate welcome page");

        return "evde";
    }

    @RequestMapping(value = "/databasetest")
    public @ResponseBody
    List<Map<String, Object>> databasetest() {
        System.out.println("Deneme");
        System.out.println("Denemmeee");

        List<Map<String, Object>> maps = transformService.listStudent();
        return transformService.listStudent();
    }

    @RequestMapping(value = "/adres",method = RequestMethod.GET)
    public @ResponseBody
    List<Map<String, Object>> databaset() {
        System.out.println("Deneme");
        System.out.println("Denemmeee");

        List<Map<String, Object>> maps = address.listAddress();
        return address.listAddress();
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

    @RequestMapping(value = "/dataGetir")
    public @ResponseBody List<Student> getSampleJSONDatas() {

        List<Map<String, Object>> maps = transformService.listStudent();
        List<Student> ls = new ArrayList<Student>();
        JSONObject jo = new JSONObject();
        for (Map<String, Object> map : maps) {
            Student s = new Student();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                jo.put("key",key);
                Object value = entry.getValue();
                jo.put("value",value);
                if(key.equals("id")){
                    s.setId(Long.valueOf(value.toString()));
                }
                else if(key.equals("ad")){
                    s.setAd(value.toString());
                }
                else if(key.equals("soyad")){
                    s.setSoyad(value.toString());
                }
            }
            ls.add(s);
        }
        return ls;


    }


}
