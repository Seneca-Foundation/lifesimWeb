package com.senecafoundation.lifesimweb.CRUD;

import com.senecafoundation.lifesimweb.IScene;
import com.senecafoundation.lifesimweb.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SceneRepoDataHandler<T extends Scene> {

    @Autowired
    SceneRepository repo;

    public void create(IScene scene) {
        repo.save((T) scene);
    }

    public IScene read(String id) throws Exception {
        return repo.findById(id.toString()).orElseThrow();
    }

    public IScene update(IScene player) {
        return repo.save((Scene) player);
    }

    public void delete(String id) throws Exception {
        repo.deleteById(id.toString());
    }

    public void read(Scene scene) {
    }

    public void delete(Scene scene) {
    }
}
