package com.senecafoundation.lifesimweb.CRUD;

import com.senecafoundation.lifesimweb.Scene;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SceneRepoDataHandler implements IDataHandler<Scene> {
    @Autowired
    SceneRepository repo;

    @Override
    public void create(Scene scene) {
        repo.save(scene);        
    }

    @Override
    public Scene read() throws Exception {
        // TODO Auto-generated method stub
        return scene;
    }

    @Override
    public Scene update(Scene scene) {
        // TODO Auto-generated method stub
        return scene;
    }

    @Override
    public void delete(Scene scene) throws Exception {
        // TODO Auto-generated method stub
        
    }
}
