package org.example.users;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void addUser(User u);

    public boolean checkUser(User u);


}
