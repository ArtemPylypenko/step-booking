package org.example.users;

import org.example.booking.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDao implements UserDao {
    List<User> users;

    public UsersDao() {
        users = new ArrayList<>();
        load();
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void addUser(User u) {
        users.add(u);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkUser(User u) {
        return users.stream().anyMatch(user -> user.getLogin().equals(u.getLogin()));
    }
    private void load(){
        try {
            FileInputStream fis = new FileInputStream("usersDB.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList<User>)ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void save() throws IOException {
        FileOutputStream fos = new FileOutputStream("usersDB.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(users);
        oos.close();
    }
}
