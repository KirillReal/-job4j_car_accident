package ru.job4j.accident.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentDataService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexControl {
    private final AccidentDataService accidentDataService;

    public IndexControl(AccidentDataService accidentDataService) {
        this.accidentDataService = accidentDataService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Accident> accidents = accidentDataService.accidentGetAll();
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal());
        model.addAttribute("accidents", accidents);
        return "index";
    }
}
