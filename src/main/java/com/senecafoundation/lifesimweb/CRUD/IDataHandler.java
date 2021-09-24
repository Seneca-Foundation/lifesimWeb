package com.senecafoundation.lifesimweb.CRUD;
public interface IDataHandler<T> { 

    public void create(T objectToSave);
    public T read() throws Exception;
    public T update(T objectToUpdate);
    public void delete(T objectToDelete) throws Exception;

}
