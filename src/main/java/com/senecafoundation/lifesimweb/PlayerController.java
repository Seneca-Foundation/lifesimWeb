package com.senecafoundation.lifesimweb;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
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
    private Errors result;

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
        dataHandler.Create(player);
        model.addAttribute("player", player);
        return "player";
    }

    @RequestMapping(value = "/updateform/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") String Id, Model model) throws Exception {
        Player player = (Player) dataHandler.Read(Id);
        model.addAttribute("player", player);
        return "update_player";
    }

    @RequestMapping(value = "/updateform", method = RequestMethod.POST)
    public String showUpdateForm(@ModelAttribute("player") Player player, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Update(player);
        model.addAttribute("player", player);
        return "player";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getRead(@PathVariable("id") String Id, Model model) {
        if (result.hasErrors()) {
            return "error";
        }
        Player player;
        try {
            player = (Player) dataHandler.Read(Id);
            model.addAttribute("player", player);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return "player";
    }

    @GetMapping("/deleteform")
    public String showFormDelete(Model model) {
        List<IPlayer> playerList = dataHandler.ReadAll();
        model.addAttribute("playerList", playerList);
        return "delete_player";
    }

    @RequestMapping(value = "/deleteform/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String Id, ModelMap model) {
        try {
            Player playerGettingDeleted = dataHandler.Read(Id);
            dataHandler.Delete(Id);
            model.addAttribute("playerGettingDeleted", playerGettingDeleted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("Id", Id);
        return "playerDelete";
    }

}

