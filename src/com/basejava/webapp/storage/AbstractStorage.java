package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void clearStorage();

    protected abstract int getIndex(String uuid);



    public void clear() {
        clearStorage();
        System.out.println("Все резюме удалены.");
    }

    


}