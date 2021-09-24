package com.senecafoundation.lifesimweb;

import com.senecafoundation.lifesimweb.CRUD.PlayerRepoDataHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("player")
public class PlayerController {

    @Autowired
    PlayerRepoDataHandler repo;
    
    @GetMapping("/createform")
    public String showForm(Model model) {
        Player player = new Player();
        model.addAttribute("player", player);
        return "create_player";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("player") Player player, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        repo.create(player);
        model.addAttribute("player", player);
        return "player";
    }
}