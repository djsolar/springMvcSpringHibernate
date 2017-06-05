package com.twinflag.controller;

import com.twinflag.entity.Person;
import com.twinflag.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by zhouyiran on 2017/6/5.
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/login")
    public String doLogin(String username, String password, Map<String, Object> map) {
        if (username.equals("admin") && password.equals("admin")) {
            map.put("username", username);
            return "frame";
        }
        return "error";
    }

    @RequestMapping("/saveperson")
    public String savePerson(Person person) {
        personService.addPerson(person);
        return "redirect:main";
    }

    @RequestMapping("/addperson")
    public String addPerson() {
        return "savepage";
    }

    @RequestMapping("/deletePersonById")
    public String deletePersonById(@RequestParam(value = "id") String id) {
        personService.deletePersonById(id);
        return "redirect:main";
    }

    @RequestMapping(value = "/updateperson")
    public String updatePerson(Person person) {
        personService.updatePerson(person);
        return "redirect:main";
    }

    @RequestMapping(value = "/doupdate")
    public String doupdate(String id, Model model) {
        model.addAttribute("person", personService.getPersonById(id));
        return "editpage";
    }

    @RequestMapping(value = "/main")
    public String main(Map<String, Object> map) {
        map.put("personlist", personService.getPersons());
        return "main";
    }
}
