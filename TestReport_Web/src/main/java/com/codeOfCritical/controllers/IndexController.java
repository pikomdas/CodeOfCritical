package com.codeOfCritical.controllers;

import com.codeOfCritical.services.DeviationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/")
public class IndexController {

    DeviationsService readData;

    @Autowired
    public void IndexController(DeviationsService readData) {
        this.readData = readData;
    }

    @GetMapping("/")
    public String main(Model model) {

        model.addAttribute("date",readData.readJSON().getDate());
        model.addAttribute("user",readData.readJSON().getUsers());
        model.addAttribute("name","Tech Mahindra");
        model.addAttribute("deviations",readData.readJSON().deviationsObject);
        return "index";
    }

}
