package com.rekik.mydayname;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;


@Controller
public class MainController {


    @GetMapping("/mydayname")
    public String takeDayNameInfo(Model model)
    {

        model.addAttribute("newdayname",new DayName());

        return "index";
    }

    @PostMapping("/mydayname")
    public String postDayNameInfo(@Valid @ModelAttribute("newdayname") DayName dayName,
                                  BindingResult result,
                                  Model model, HttpServletRequest request)
    {
        String entereddate = request.getParameter("getdob");
        String viewgender = request.getParameter("gender");

        DayName getname = new DayName(entereddate);
        model.addAttribute("entereddate", getname.fullDateFormat());
        model.addAttribute("gender",viewgender);

        if(viewgender.equalsIgnoreCase("female"))
        {
            model.addAttribute("femalename", getname.getFemalename());
        }
        if(viewgender.equalsIgnoreCase("male"))
        {
            model.addAttribute("malename", getname.getMalename());
        }

        return "mydayname";

    }

    }











