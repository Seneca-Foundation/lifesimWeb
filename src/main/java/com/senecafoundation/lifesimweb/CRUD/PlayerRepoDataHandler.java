package com.senecafoundation.lifesimweb.CRUD;

import java.util.ArrayList;
import java.util.UUID;

import com.senecafoundation.lifesimweb.IPlayer;
import com.senecafoundation.lifesimweb.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerRepoDataHandler<T extends Player> implements IDataHandler {

    @Autowired
    PlayerRepository repo;

    @Override 
    public void Create(IPlayer player) {
        repo.save((T) player);
    }

    @Override
    public Player Read(String uuid) throws Exception {
        return repo.findById(uuid).orElseThrow();
    }

    public ArrayList<IPlayer> ReadAll() {
        ArrayList<IPlayer> listOfItemsToReturn = new ArrayList<IPlayer>();
        for (Player player : this.repo.findAll()) {
            listOfItemsToReturn.add(player);
        }
        return listOfItemsToReturn;
    }

    @Override
    public Player Update(IPlayer player) {
        return repo.save((Player) player);
    }

    @Override
    public Boolean Delete(String Id) throws Exception {
        repo.deleteById(Id);
        return true;
    }
}
