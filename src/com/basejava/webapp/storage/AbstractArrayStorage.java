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

    protected abstract void addToArray(Resume resume, int index);

    protected abstract void removeFromArray(int index);

    @Override
    protected void clearStorage() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void updateResumeInStorage(int index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected void addResumeToStorage(Resume resume, int index) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Хранилище заполнено", resume.getUuid());
        } else {
            addToArray(resume, index);
            size++;
        }
    }

    @Override
    protected Resume getResumeFromStorage(int index) {
        return storage[index];
    }

    @Override
    protected void removeResumeFromStorage(int index) {
        removeFromArray(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Resume[] getAllResumeFromStorage() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    protected int sizeOfStorage() {
        return size;
    }
}
