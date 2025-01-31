package gr.aueb.cf.inspirecraft.service;


import gr.aueb.cf.inspirecraft.dto.UserInsertDTO;
import gr.aueb.cf.inspirecraft.dto.UserUpdateDTO;
import gr.aueb.cf.inspirecraft.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    User saveUser(UserInsertDTO userInsertDTO);
    User updateUser(UserUpdateDTO userUpdateDTO);
    void deleteUser(Long id);
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserById(Long id);
    List<User> getUsersByLastname(String lastname);
    List<User> getAllUsers();

}
