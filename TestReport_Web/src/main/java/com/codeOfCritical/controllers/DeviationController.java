package com.codeOfCritical.controllers;


import com.codeOfCritical.services.DeviationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DeviationController {

    @Autowired
    DeviationsService readData;

    @RequestMapping(value = "/scenarios", method = RequestMethod.GET)
    public String list(Model model) {
        Map<String,String> scenario=new HashMap<>();
        scenario.put("serverTime", LocalDate.now().toString());
        model.addAttribute("deviations", String.valueOf(readData.readJSON().listAllFailedScenarios()));
//        model.addAttribute("serverTime", LocalDate.now());
        System.out.println("Returning deviations:");
        return model.getAttribute("deviations").toString();
//        return "scenarios";
    }

    /*@RequestMapping("deviation/{id}")
    public String showProduct(@PathVariable String name, Model model) {
        model.addAttribute("deviations", readData.readJSON().getDeviationsByScenarioName(name));
        return "productshow";
    }

    @RequestMapping("deviation/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("deviations", readData.readJSON().getDeviationsByScenarioName(id));
        return "productform";
    }

    @RequestMapping("deviation/new")
    public String newProduct(Model model) {
        model.addAttribute("deviations", new Deviations());
        return "productform";
    }

    @RequestMapping(value = "deviation", method = RequestMethod.POST)
    public String saveProduct(Deviations product) {

        readData.readJSON().saveDeviations(product);

        return "redirect:/deviation/" + product.getScenarioName();
    }*/
}
