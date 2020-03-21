package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size = 0;


    protected void checkSizeForArrayStorage(String uuid) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Хранилище заполнено", uuid);
        }
    }



    @Override
    protected void clearStorage() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }


    public void updateResume(int index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected Resume gettingResumeFromStorage(int index) {
        return storage[index];
    }



    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

}
