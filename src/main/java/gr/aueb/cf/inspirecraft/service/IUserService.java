package gr.aueb.cf.inspirecraft.service;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectAlreadyExistsException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectInvalidArgumentException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectNotFoundException;
import gr.aueb.cf.inspirecraft.dto.UserInsertDTO;
import gr.aueb.cf.inspirecraft.dto.UserUpdateDTO;
import gr.aueb.cf.inspirecraft.model.User;
import java.util.List;
import java.util.Optional;

public interface IUserService {

    User saveUser(UserInsertDTO userInsertDTO)
            throws AppObjectAlreadyExistsException, AppObjectInvalidArgumentException;
    User updateUser(UserUpdateDTO userUpdateDTO)
            throws AppObjectInvalidArgumentException, AppObjectNotFoundException;
    void deleteUser(Long id) throws AppObjectNotFoundException;
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserById(Long id);
    List<User> getUsersByLastname(String lastname);
    List<User> getAllUsers();

}
