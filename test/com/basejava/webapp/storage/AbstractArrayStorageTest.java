package com.basejava.webapp.storage;

import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {

    protected Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    public static final String UUID_1 = "uuid1";
    public static final String UUID_2 = "uuid3";
    public static final String UUID_3 = "uuid2";
    public static final String UUID = "uu"; //for deleteNotExist and getNotExist

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));

    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        storage.update(storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(new Resume());
    }

    @Test
    public void save() throws Exception {
        for (int i = 4; i <= 10_000; i++) {
            try {
                storage.save(new Resume());
            }
            catch (StorageException e) {
                Assert.fail("Array overflow error");
            }
        }
    }

    @Test(expected = StorageException.class)
    public void saveOverflowError() throws Exception {
        for (int i = 3; i <= 10_000; i++) {
            storage.save(new Resume());
        }
    }

    @Test(expected = ExistStorageException.class)
    public void saveExistError() throws Exception {
        storage.save(new Resume(UUID_1));
    }

    @Test
    public void get() throws Exception {
            storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get(UUID);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete(UUID);
    }

    @Test
    public void getAll() throws Exception {
        int checkSize = 0;
        Resume[] check = storage.getAll();
        for (Resume r : storage.getAll()) {
            checkSize++;
        }
        check[0].equals(storage.get(UUID_1));
        check[1].equals(storage.get(UUID_2));
        check[2].equals(storage.get(UUID_3));
        Assert.assertEquals(storage.size(), checkSize);

    }
}