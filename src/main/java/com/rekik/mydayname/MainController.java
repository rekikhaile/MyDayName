package com.rekik.mydayname;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

@Controller
public class MainController {


    @RequestMapping("/")
    public String myDayName() {

        return "index";
    }

    @GetMapping("/mydayname")
    public String takeDayNameInfo(Model model)
    {

        model.addAttribute("newdayname",new DayName());

        return "mydayname";
    }

    @PostMapping("/mydayname")
    public String postDayNameInfo(@Valid @ModelAttribute("newdayname") DayName dayName,
                               BindingResult result,
                               Model model)
    {

        if(result.hasErrors())
        {
            return "mydayname";
        }

        Scanner keyboard = new Scanner(System.in);

        //Get the current time
        LocalDateTime rightNow = LocalDateTime.now();
        //Date from the user
        LocalDate userDate = null;
        //Set up formatters so that you can use them later
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter shortMonthFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        DateTimeFormatter longFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        //Time formatter (time only)
        DateTimeFormatter hr24 = DateTimeFormatter.ofPattern("kk:m");
        do{
            System.out.println("Enter a date in the past(dd/mm/yyyy)");
            try{

                userDate = LocalDate.parse(keyboard.nextLine(),dTF);

            }catch(Exception e)
            {
                if(userDate.isAfter(LocalDate.now())&&userDate!=null)
                    System.out.println("The date must be in the past");

                System.out.println("Unable to convert the string you entered to date. Please try again!");

            }

        }while(userDate==null);


        //new SimpleDateFormat(aPattern, DateFormatSymbols.getInstance(aLocale)).

        //SimpleDateFormat(dTF, obSymbols)

        // create instance of DateFormatSymbols class
        DateFormatSymbols obSymbols = DateFormatSymbols.getInstance();


        // Array of weekdays' name
        String[] weekDaysNameArray = obSymbols.getWeekdays();


        // Display name of weekday
        for(int i = 1;i<weekDaysNameArray.length;i++)

        {

            String nameOfDay = weekDaysNameArray[i];
            System.out.println("Full name of day : " + nameOfDay);

        }



        return "redirect:/";

    }



    }











