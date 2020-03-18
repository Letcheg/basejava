package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class ListStorage extends AbstractStorage {

    protected static ArrayList<Resume> storage = new ArrayList<Resume>();


    @Override
    public void clearStorage() {
        storage.clear();
    }

    @Override
    protected int getIndex(String uuid) {
        Iterator<Resume> iterator = storage.iterator();
        while (iterator.hasNext()) {
            Resume r = iterator.next();
            if (Objects.equals(r.getUuid(), uuid)) {
                return storage.indexOf(r);
            }

        }
        return -1;
    }


    @Override
    public void update(Resume resume) {
        if (storage.contains(resume)) {
            int index = storage.indexOf(resume);
            storage.set(index, resume);
        }
    }

    @Override
    public void save(Resume resume) {
        if (storage.contains(resume)) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            storage.add(resume);
            System.out.println("Резюме " + resume.getUuid() + " сохранено в хранилище.  " + "Общее количество резюме " + storage.size());
        }
    }


    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else return storage.get(index);
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            storage.remove(index);
            System.out.println("Выполнено: Резюме " + uuid + " удалено. ");
        }
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
