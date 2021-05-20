package ru.job4j.accident.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.service.AccidentDataService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class AccidentControl {

    private final AccidentDataService accidents;

    @Autowired
    public AccidentControl(AccidentDataService accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<AccidentType> types = accidents.getAccidentTypesList();
        model.addAttribute("types", types);
        List<Rule> rules = accidents.getAllRule();
        model.addAttribute("rules", rules);
        model.addAttribute(
                "user", SecurityContextHolder.getContext().getAuthentication().getPrincipal()
        );
        return "accident/create";
    }

    @GetMapping("/edit")
    public String showAccident(@RequestParam("id") int id, Model model) {
        List<AccidentType> types = accidents.getAccidentTypesList();
        model.addAttribute("types", types);
        model.addAttribute("accident", accidents.findAccident(id));
        List<Rule> rules = accidents.getAllRule();
        model.addAttribute("rules", rules);
        model.addAttribute(
                "user", SecurityContextHolder.getContext().getAuthentication().getPrincipal()
        );
        return "accident/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        Arrays.stream(ids).forEach(id -> accident
                .addRule(accidents.findByIdRule(Integer.parseInt(id))));
        accidents.createOrUpdate(accident);
        return "redirect:/";
    }

}
