package com.senecafoundation.lifesimweb.CRUD;

import java.util.List;

import com.senecafoundation.lifesimweb.IPlayer;
import com.senecafoundation.lifesimweb.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerRestController {
    
    @Autowired
    @Qualifier("plantDataWriter")
    PlayerRepoDataHandler dataHandler;

    @PostMapping("/players")
    Player newPlayers(@RequestBody Player newPlayers) {
        dataHandler.Create(newPlayers);
        return newPlayers;
    }

    @GetMapping("/players")
    List<IPlayer> allPlayers() {
        return dataHandler.ReadAll();
    }
    
    @PutMapping("/players/{id}")
    Player replacePlayers(@RequestBody Player newPlayers, @PathVariable String id) throws Exception {
        Player players = (Player) dataHandler.Read(id);
        if (players != null) {
            newPlayers.setId(players.getId());
            dataHandler.Update(newPlayers);
            return newPlayers;
        }
        else {
            throw new Exception("Player with id: " + id + " not found.");
        }
    }

    @DeleteMapping("/players/{id}")
    void deletePlayers(@PathVariable String id) throws Exception
    {
        dataHandler.Delete(id);
    }
    
}