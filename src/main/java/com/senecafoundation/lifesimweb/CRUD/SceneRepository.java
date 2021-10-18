package com.senecafoundation.lifesimweb.CRUD;

import com.senecafoundation.lifesimweb.Scene;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SceneRepository extends MongoRepository<Scene, String> {
}