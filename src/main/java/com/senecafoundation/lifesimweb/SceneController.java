package com.senecafoundation.lifesimweb;

import com.senecafoundation.lifesimweb.CRUD.SceneRepoDataHandler;

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
@RequestMapping("scene")
public class SceneController {

    @Autowired
    SceneRepoDataHandler<Scene> dataHandler;
    
    @GetMapping("/createform")
    public String showForm(Model model) {
        Scene scene = new Scene();
        model.addAttribute("scene", scene);
        return "create_scene";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("scene") Scene scene, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.create(scene);
        model.addAttribute("scene", scene);
        return "scene";
    }
}