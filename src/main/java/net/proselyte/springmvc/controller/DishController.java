package net.proselyte.springmvc.controller;


import net.proselyte.springmvc.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import net.proselyte.springmvc.model.Dish;
import net.proselyte.springmvc.model.Menu;
import net.proselyte.springmvc.service.DishService;
import net.proselyte.springmvc.service.MenuService;

/**
 * Created by Администратор on 04.08.16.
 */


@Controller
public class DishController {



    private DishService dishService;
    private String dishName;
    private long dishId;
    private MenuService menuService;


    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }



    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }



   @RequestMapping(value = "/dishes", method = RequestMethod.GET)
    public String dishes(Map<String, Object> model) {
       System.out.println("Dishes will be show soon");
       model.put("dishes", dishService.getDishes());
      return "dishes";
    }

    @RequestMapping(value = "/dish", method = RequestMethod.GET)
    public ModelAndView dish(@RequestParam("dishName")String dishName) {
        ModelAndView modelAndView = new ModelAndView();
        Dish dish = dishService.getDishByName(dishName);
        modelAndView.addObject("dish", dish);
        modelAndView.addObject("ingradients", dishService.getDishByName(dishName).getIngradients());
        modelAndView.setViewName("dish");
        this.dishName = dishName;
        this.dishId = dish.getId();
        return modelAndView;

    }

    @RequestMapping(value = "addDish", method = RequestMethod.GET)
    public ModelAndView dish() {
       return new ModelAndView("/addDish", "command", new Dish());

    }

    @RequestMapping(value = "/newDish", method = RequestMethod.POST)
    public String addDish(@ModelAttribute("mvc-dispatcher") Dish dish,
                          ModelMap model) throws IOException{
        if(dish.getName().length() == 0)
            throw new IOException("You have not entered dish name");
        if(dish.getPrice() < 1 || dish.getWeight() < 1 )
            throw new NumberFormatException("Invalid number of dish");
      dishService.saveDish(dish);
      model.addAttribute("message", "New dish was added successfully");
      return "result";
    }


    @RequestMapping(value = "/addIngradientToDish", method = RequestMethod.POST)
    public String addIngradient(@RequestParam("name") String name, ModelMap model) throws IOException {
        System.out.println("dish name = "+dishName);
       dishService.addIngradient(dishName, name);
        model.addAttribute("message", "New ingradient was added to dish successfully");
        return "result";
    }

    @RequestMapping(value = "/ingradientToDish", method = RequestMethod.GET)
    public String Ingradient() {
        return "/ingradientToDish";
    }


    @RequestMapping(value = "/ingradientFromDish", method = RequestMethod.GET)
    public String removeDish() {
        return "/ingradientFromDish";
    }


    @RequestMapping(value = "/removeIngradientFromDish", method = RequestMethod.POST)
    public String removeIngradient(@RequestParam("name") String name, ModelMap model) throws IOException {
        dishService.removeIngradient(dishName,name);
        model.addAttribute("message", "Ingradient was deleted from dish successfully");
        return "result";
    }

    @RequestMapping(value = "/removeDish", method = RequestMethod.GET)
    public String removeDish(ModelMap model) {
        dishService.removeDish(dishId);
        model.addAttribute("message", "Dish was deleted successfully");
        return "result";
    }



    @RequestMapping(value = "/changeWeight", method = RequestMethod.GET)
    public String setNewWeight(@RequestParam("newWeight") float newWeight, ModelMap model) throws IOException {
       dishService.changeWeight(dishId, newWeight);
        model.addAttribute("message", "Weight was change successfully");
        return "result";

    }


    @RequestMapping(value = "/changePrice", method = RequestMethod.GET)
    public String setNewPrice(@RequestParam("newPrice") float newPrice, ModelMap model) throws IOException {
        dishService.changePrice(dishId,newPrice);
        model.addAttribute("message", "Price was change successfully");
        return "result";
    }

    @RequestMapping(value = "/showDishes", method = RequestMethod.GET)
    public String showDishes(@RequestParam("menuName")String menuName, Map<String, Object> model) {
        Menu menu =  menuService.getMenuByName(menuName);
        model.put("menu", menu.getName() );
        model.put("dishes", menu.getDishes() );
        return "showDishes";
    }

    @RequestMapping(value = "/showDish", method = RequestMethod.GET)
    public ModelAndView showDish(@RequestParam("dishName")String dishName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dish", dishService.getDishByName(dishName));
        modelAndView.addObject("ingradients", dishService.getDishByName(dishName).getIngradients());
        modelAndView.addObject("image", "club_shema_1.jpg");
        modelAndView.setViewName("showDish");
        return modelAndView;
    }

}
