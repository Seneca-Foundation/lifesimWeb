package com.senecafoundation.lifesimweb;

import com.senecafoundation.lifesimweb.CRUD.SceneRepoDataHandler;
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
@RequestMapping("scene")
public class SceneController {

    @Autowired
    SceneRepoDataHandler<Scene> dataHandler;
    private Errors result;

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

    @RequestMapping(value = "/readform/{id}", method = RequestMethod.GET)
    public String getRead(@PathVariable("id") String Id, Model model) {
        if (result.hasErrors()) {
            return "error";
        }
        Scene scene;
        try {
            scene = (Scene) dataHandler.read(Id);
            model.addAttribute("scene", scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "scene";
    }

    @RequestMapping(value = "/updateform/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") String Id, Model model) throws Exception {
        Scene scene = (Scene) dataHandler.read(Id);
        model.addAttribute("scene", scene);
        return "update_scene";
    }

    @RequestMapping(value = "/updateform", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("scene") Scene scene, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.update(scene);
        model.addAttribute("scene", scene);
        return "scene";
    }

    @GetMapping("/deleteform")
    public String showDeleteForm(Model model) {
        Scene scene = new Scene();
        model.addAttribute("scene", scene);
        return "delete_scene";
    }

    @RequestMapping(value = "/deleteform", method = RequestMethod.DELETE)
    public String submitDelete(@ModelAttribute("scene") Scene scene, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.delete(scene);
        model.addAttribute("scene", scene);
        return "scene";
    }

}