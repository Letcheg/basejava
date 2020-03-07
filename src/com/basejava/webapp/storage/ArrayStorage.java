package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage extends com.basejava.webapp.storage.AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void addResumeToStorage(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    public void remove(int index) {
        storage[index] = storage[size - 1];

    }
}

