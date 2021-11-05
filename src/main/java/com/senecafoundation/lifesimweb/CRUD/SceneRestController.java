package com.senecafoundation.lifesimweb.CRUD;

import java.util.List;

import com.senecafoundation.lifesimweb.IScene;
import com.senecafoundation.lifesimweb.Scene;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SceneRestController {
    
    @Autowired
    SceneRepoDataHandler<Scene> dataHandler;

    @PostMapping("/scenes")
    Scene newScene(@RequestBody Scene newScenes) {
        System.out.println("New Scene: " + newScenes);
        dataHandler.Create(newScenes);
        return newScenes;
    }

    @GetMapping("/scenes")
    List<IScene> allScenes() {
        return dataHandler.ReadAll();
    }
    
    @PutMapping("/scenes/{id}")
    Scene replaceScenes(@RequestBody Scene newScenes, @PathVariable String id, Scene Scenes) throws Exception {
        Scene scenes = (Scene) dataHandler.Read(id);
        if (scenes != null) {
            newScenes.setId(Scenes.getId());
            dataHandler.Update(newScenes);
            return newScenes;
        }
        else {
            throw new Exception("Scene with id: " + id + " not found.");
        }
    }

    @DeleteMapping("/scenes/{id}")
    void deleteScenes(@PathVariable String id) throws Exception
    {
        dataHandler.Delete(id);
    }
    
}