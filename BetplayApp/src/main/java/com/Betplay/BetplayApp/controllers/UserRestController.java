package com.Betplay.BetplayApp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Betplay.BetplayApp.models.User;
import com.Betplay.BetplayApp.models.dto.UserDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/user")

public class UserRestController {


    @GetMapping("/details")
    public UserDto details(){
        User user = new User("Papa", "pollito");
        UserDto userdto = new UserDto();
        userdto.setTitle("ingeniero");
        userdto.setUser(user);
        return userdto;
    }
    // public Map<String,Object> details(){
        
    //     Map<String,Object> body = new HashMap<>();
    //     User user = new User("Papa", "Pollito");
    //     body.put("title", "Desarrollando con Spring boot CreativeCode");
    //     body.put("author", "Johlver Pardo");
    //     return body;
    // }
    @GetMapping("/list-details")
    public List<User> listdetails(){
        User user = new User("juan", "perez");
        User userA = new User("daniel", "juarez");
        User userB = new User("martha", "estupiñan");
        List<User> IstUsers = new ArrayList<>();
        IstUsers.add(user);
        IstUsers.add(userA);
        IstUsers.add(userB);
        return IstUsers;
    }
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name= "name", defaultValue= "world") 
    String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        model.addAttribute("query", query);
        return "searchResults";
    }
    @GetMapping("/user")
    public String user(@RequestParam(name = "id", required = false) 
    String id, Model model) {
        model.addAttribute("id", id);
        return "userProfile";
    }
    
}