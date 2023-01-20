package org.example.users;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDao implements UserDao {
    ArrayList<User> users;
    private final String filename;

    public UsersDao(String filename) {
        this.filename = filename;
        users = new ArrayList<>();
        load();
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void addUser(User u) {
        if (!checkUser(u)) {
            users.add(u);
            try {
                save();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Such user exist!");
        }
    }

    @Override
    public boolean checkUser(User u) {
        return users.stream().anyMatch(user -> user.getLogin().equals(u.getLogin()));
    }

    private void load() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList<User>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void save() throws IOException {
        FileOutputStream fos = new FileOutputStream(filename, false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(users);
        oos.close();
    }
}
