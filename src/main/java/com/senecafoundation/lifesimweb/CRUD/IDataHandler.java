package com.senecafoundation.lifesimweb.CRUD;

import com.senecafoundation.lifesimweb.IPlayer;

public interface IDataHandler { 

    public void Create(IPlayer objectToSave);
    public IPlayer Read(String id) throws Exception;
    public IPlayer Update(IPlayer objectToUpdate);
    public Boolean Delete(String id) throws Exception;

}
