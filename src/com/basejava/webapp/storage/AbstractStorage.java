package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void clearStorage();

    protected abstract void updateResumeInStorage(int index, Resume resume);

    protected abstract void addResumeToStorage(Resume resume, int index);

    protected abstract Resume getResumeFromStorage(int index);

    protected abstract void removeResumeFromStorage(int index);

    protected abstract Resume[] getAllResumeFromStorage();

    protected abstract int sizeOfStorage();

    protected abstract int getIndex(String uuid);

    public void clear() {
        clearStorage();
        System.out.println("Все резюме удалены.");
    }

    public void update(Resume resume) {
        String uuid = resume.getUuid();
        int index = getIndex(uuid);
        checkNotExist(index, uuid);
        updateResumeInStorage(index, resume);
        System.out.println("Резюме " + resume + " обновлено.");
    }

    public void save(Resume resume) {
        String uuid = resume.getUuid();
        int index = getIndex(uuid);
        if (index >= 0) {
            throw new ExistStorageException(uuid);
        } else {
            addResumeToStorage(resume, index);
            System.out.println("Резюме " + uuid + " сохранено в хранилище. Общее количество резюме = " + this.size());
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        checkNotExist(index, uuid);
        return getResumeFromStorage(index);
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        checkNotExist(index, uuid);
        removeResumeFromStorage(index);
        System.out.println("Выполнено: Резюме " + uuid + " удалено. ");
    }

    public Resume[] getAll() {
        return getAllResumeFromStorage();
    }

    public int size() {
        return sizeOfStorage();
    }

    private void checkNotExist(int index, String uuid) {
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
    }
}

