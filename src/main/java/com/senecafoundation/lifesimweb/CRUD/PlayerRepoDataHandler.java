package com.senecafoundation.lifesimweb.CRUD;

import com.senecafoundation.lifesimweb.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerRepoDataHandler implements IDataHandler {
    @Autowired
    PlayerRepository repo;

    @Override
    public void createPlayer(Player player) {
        repo.save(player);        
    }

    @Override
    public Player readPlayer() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Player updatePlayer(Player player) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deletePlayer(Player player) throws Exception {
        // TODO Auto-generated method stub
        
    }
    
}
