package com.senecafoundation.lifesimweb.CRUD;

import java.util.UUID;

import com.senecafoundation.lifesimweb.IPlayer;

public interface IDataHandler { 

    public void create(IPlayer objectToSave);
    public IPlayer read(String id) throws Exception;
    public IPlayer update(IPlayer objectToUpdate);
    public Boolean delete(String id) throws Exception;

}
