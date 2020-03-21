package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void clearStorage();

    protected abstract int getIndex(String uuid);

    protected abstract void updateResume(int index, Resume resume);

    protected abstract void addResumeToStorage(Resume resume, int index);

    protected abstract Resume gettingResumeFromStorage(int index);

    protected abstract void remove(int index);


    public void clear() {
        clearStorage();
        System.out.println("Все резюме удалены.");
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            updateResume(index, resume);
            System.out.println("Резюме " + resume + " обновлено.");
        }
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

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else
            return gettingResumeFromStorage(index);
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            remove(index);
            System.out.println("Выполнено: Резюме " + uuid + " удалено. ");
        }
    }
}

