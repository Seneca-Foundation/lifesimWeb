package com.senecafoundation.lifesimweb.CRUD;

import java.util.List;

import com.senecafoundation.lifesimweb.IScene;
import com.senecafoundation.lifesimweb.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SceneRepoDataHandler<T extends Scene> {

    @Autowired
    SceneRepository repo;

    public void Create(IScene scene) {
        repo.save((T) scene);
    }

    public Scene Read(String id) throws Exception {
        return repo.findById(id.toString()).orElseThrow();
    }

    public IScene Update(IScene player) {
        return repo.save((Scene) player);
    }

    public void Delete(String id) throws Exception {
        repo.deleteById(id.toString());
    }

    public List<IScene> ReadAll() {
        return null;
    }
}
