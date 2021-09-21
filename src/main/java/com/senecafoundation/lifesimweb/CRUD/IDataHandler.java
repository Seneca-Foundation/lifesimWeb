package com.senecafoundation.lifesimweb.CRUD;

import com.senecafoundation.lifesimweb.Player;

public interface IDataHandler { 
    public void createPlayer(Player player);
    public Player readPlayer() throws Exception;
    public Player updatePlayer(Player player);
    public void deletePlayer(Player player) throws Exception;
}