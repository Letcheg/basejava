package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    protected static Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected void clearStorage() {
        mapStorage.clear();
    }
      /*  map.put(UUID_1, RESUME_1);
        map.put(UUID_2, RESUME_2);
        map.put(UUID_3, RESUME_3);

        // Bad!
        for (String uuid : map.keySet()) {
            System.out.println(map.get(uuid));
        }

        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
    }*/

    @Override
    protected void updateResumeInStorage(int index, Resume resume, String uuid) {



    }

    @Override
    protected void addResumeToStorage(Resume resume, int index, String uuid) {

    }

    @Override
    protected Resume getResumeFromStorage(int index) {
        return null;
    }

    @Override
    protected void removeResumeFromStorage(int index) {

    }


    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
