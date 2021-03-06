package com.senecafoundation.lifesimweb;

import com.senecafoundation.lifesimweb.CRUD.PlayerRepoDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("player")
public class PlayerController {

    @Autowired
    PlayerRepoDataHandler<Player> dataHandler;

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
        dataHandler.create(player);
        model.addAttribute("player", player);
        return "player";
    }

    @RequestMapping(value = "/updateform/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") String Id, Model model) throws Exception {
        Player player = (Player) dataHandler.read(Id);
        model.addAttribute("player", player);
        return "update_player";
    }

    @RequestMapping(value = "/updateform", method = RequestMethod.POST)
    public String showUpdateForm(@ModelAttribute("player") Player player, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.update(player);
        model.addAttribute("player", player);
        return "player";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showFormRead(@PathVariable("id") String Id, Model model, Object Player) {
        Player player;
        try {
            Player = (Player) dataHandler.read(Id);
            model.addAttribute("player", Player);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return "player";
    }
}