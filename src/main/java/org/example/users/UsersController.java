package org.example.users;

import java.util.List;

public class UsersController {
    UserService service;

    public UsersController(UserService service) {
        this.service = service;
    }

    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    public void addUser(User u) {
        service.addUser(u);
    }

    public boolean checkUser(User u) {
        return service.checkUser(u);
    }

}
