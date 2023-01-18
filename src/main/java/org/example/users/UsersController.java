package org.example.users;

import java.util.List;

public class UsersController {
    UsersDao dao;

    public UsersController(UsersDao dao) {
        this.dao = dao;
    }

    public List<User> getAllUsers(){
        return dao.getAllUsers();
    }

    public void addUser(User u){
        dao.addUser(u);
    }

    public boolean checkUser(User u){
        return dao.checkUser(u);
    }

}
