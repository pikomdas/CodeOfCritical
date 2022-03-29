package com.codeOfCritical.controllers;


import com.codeOfCritical.domain.Deviations;
import com.codeOfCritical.services.DeviationsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeviationController {

    private DeviationsService deviationService;

    /*@Autowired
    public void setdeviationService(DeviationsService deviationService) {
        this.deviationService = deviationService;
    }*/

    @RequestMapping(value = "/deviation", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("deviations", deviationService.listAllScenarios());
        System.out.println("Returning deviations:");
        return "index";
    }

    @RequestMapping("deviation/{id}")
    public String showProduct(@PathVariable String name, Model model) {
        model.addAttribute("deviations", deviationService.getDeviationsByScenarioName(name));
        return "productshow";
    }

    @RequestMapping("deviation/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("deviations", deviationService.getDeviationsByScenarioName(id));
        return "productform";
    }

    @RequestMapping("deviation/new")
    public String newProduct(Model model) {
        model.addAttribute("deviations", new Deviations());
        return "productform";
    }

    @RequestMapping(value = "deviation", method = RequestMethod.POST)
    public String saveProduct(Deviations product) {

        deviationService.saveDeviations(product);

        return "redirect:/deviation/" + product.getScenarioName();
    }

}
