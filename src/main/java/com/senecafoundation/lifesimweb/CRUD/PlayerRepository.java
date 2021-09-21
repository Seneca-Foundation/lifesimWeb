package com.senecafoundation.lifesimweb.CRUD;

import com.senecafoundation.lifesimweb.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String> {
}