package com.userservice.service;


import com.userservice.model.UserDetail;

public interface UserService {

    //creating user
    public UserDetail createUser(UserDetail user) throws Exception;

    //get user by username
    public UserDetail getUser(String username);

    //delete user by id
    public void deleteUserById(Long id);
}
