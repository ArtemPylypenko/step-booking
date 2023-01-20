package org.example.users;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersDaoTest {

    @Test
    void getAllUsers() {
        UsersDao dao = new UsersDao("testDB.txt");
        User test1 = new User("test1","123");
        User test2 = new User("test2","123");
        dao.addUser(test1);
        dao.addUser(test2);
        assertEquals(test1.toString(),dao.getAllUsers().get(0).toString());
        assertEquals(test2.toString(),dao.getAllUsers().get(1).toString());

    }

    @Test
    void addUser() {
        UsersDao dao = new UsersDao("testDB.txt");
        User test1 = new User("test1","123");
        User test2 = new User("test2","123");
        dao.addUser(test1);
        dao.addUser(test2);
        assertEquals(test1.toString(),dao.getAllUsers().get(0).toString());
        assertEquals(test2.toString(),dao.getAllUsers().get(1).toString());
    }

    @Test
    void checkUser() {
        UsersDao dao = new UsersDao("testDB.txt");
        User test1 = new User("test1","123");
        User test2 = new User("test2","123");
        dao.addUser(test1);
        dao.addUser(test2);
        assertEquals(test1.toString(),dao.getAllUsers().get(0).toString());
        assertEquals(test2.toString(),dao.getAllUsers().get(1).toString());
    }

    @Test
    void save() {
        UsersDao dao = new UsersDao("testDB.txt");
        User test1 = new User("test1","123");
        User test2 = new User("test2","123");
        dao.addUser(test1);
        dao.addUser(test2);
        assertEquals(test1.toString(),dao.getAllUsers().get(0).toString());
        assertEquals(test2.toString(),dao.getAllUsers().get(1).toString());
    }
}