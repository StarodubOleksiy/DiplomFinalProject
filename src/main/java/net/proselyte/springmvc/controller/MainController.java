package net.proselyte.springmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import net.proselyte.springmvc.model.Dish;
import net.proselyte.springmvc.service.DishService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;




@Controller
public class MainController  {
    private DishService dishService;

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    private DishController dishController;

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }


    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "<h1>Ласкаво просимо в наш ресторан - ...!!!</h1>");
        model.addObject("message", "<h1>Адреса: місто Львів Вулиця Любінська. </h1>\n" +
                                 "<h1>Контактний телефон : 123-456-789-0</h1>\n" +
                                 "<h1>Електронна пошта:restoran@mail</h1>");
        model.setViewName("index");
        return model;

    }





    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "This page is for administrator!");
        model.addObject("message", "You can manage the restaurant from this page!");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }




    @RequestMapping(value= "/schema", method = RequestMethod.GET)
    public String schema() {
        return "schema";
    }


    @RequestMapping(value= "/contacts", method = RequestMethod.GET)
    public String contacts() {
        return "contacts";
    }

    @RequestMapping(value = "/findByWord", method = RequestMethod.GET)
    public ModelAndView findDish(@RequestParam("name") String name) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        Dish dish = dishService.getDishByName(name);
        if(dish == null) {
            System.out.println("This is exception");
            throw new IOException("This dish have not found!!!");
        }
        modelAndView.addObject("finddish", dish);
        modelAndView.setViewName("index");

        return modelAndView;
    }






}




