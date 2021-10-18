package com.senecafoundation.lifesimweb.CRUD;

import java.util.ArrayList;
import java.util.List;
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
    public void create(IPlayer player) {
        repo.save((T) player);
    }

    @Override
    public Player read(String uuid) throws Exception {
        return repo.findById(uuid).orElseThrow();
    }

    public List<IPlayer> ReadAll() {
        ArrayList<IPlayer> listOfItemsToReturn = new ArrayList<IPlayer>();
        for (Player player : this.repo.findAll()) {
            listOfItemsToReturn.add(player);
        }
        return listOfItemsToReturn;
    }

    @Override
    public Player update(IPlayer player) {
        return repo.save((Player) player);
    }

    @Override
    public Boolean delete(String id) throws Exception {
        repo.deleteById(id.toString());
        return true;
    }

    public void read(Player player) {
    }

    public void update(String id) {
    }

    public Player Read(UUID fromString) {
        return null;
    }

}
