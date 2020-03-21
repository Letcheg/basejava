package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    protected static ArrayList<Resume> storage = new ArrayList<Resume>();


    @Override
    public void clearStorage() {
        storage.clear();
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }


    public void updateResume(int index, Resume resume) {
        storage.set(index, resume);
    }

    @Override
    protected void addResumeToStorage(Resume resume, int index) {
        storage.add(resume);
    }

    @Override
    protected Resume gettingResumeFromStorage(int index) {
        return storage.get(index);
    }

    @Override
    protected void remove(int index) {
        storage.remove(index);
    }


    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
