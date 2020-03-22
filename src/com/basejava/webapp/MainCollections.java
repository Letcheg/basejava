package com.basejava.webapp;

import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.ListStorage;
import com.basejava.webapp.storage.Storage;

import java.lang.reflect.InvocationTargetException;

public class MainCollections {
    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3 = new Resume(UUID_3);

    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_4 = new Resume(UUID_4);
    private final static Storage collection = new ListStorage();

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        collection.clear();
        collection.save(RESUME_1);
        collection.save(RESUME_2);
        collection.save(RESUME_3);
        collection.save(RESUME_4);
        collection.save(new Resume());
        collection.update(RESUME_1);
        printAll();


        System.out.println("Get r1: " + collection.get(RESUME_1.getUuid()));
        System.out.println("Get r3: " + collection.get(RESUME_3.getUuid()));
        System.out.println("Size: " + collection.size());

        System.out.println("Get dummy: " + collection.get("dummy"));

        printAll();
        collection.delete(UUID_1);
        printAll();
        collection.clear();
        printAll();

        System.out.println("Size: " + collection.size());

    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : collection.getAll()) {
            System.out.println(r);
        }
    }
}

