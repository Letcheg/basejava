package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    protected static List<Resume> storage = new ArrayList<>();

    @Override
    protected void clearStorage() {
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

    @Override
    protected void updateResumeInStorage(int index, Resume resume, String uuid) {
        storage.set(index, resume);
    }

    @Override
    protected void addResumeToStorage(Resume resume, int index, String uuid) {
        storage.add(resume);
    }

    @Override
    protected Resume getResumeFromStorage(int index) {
        return storage.get(index);
    }

    @Override
    protected void removeResumeFromStorage(int index) {
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
