package gr.aueb.cf.inspirecraft.service;

import gr.aueb.cf.inspirecraft.dto.UserInsertDTO;
import gr.aueb.cf.inspirecraft.dto.UserUpdateDTO;
import gr.aueb.cf.inspirecraft.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    @Override
    public User saveUser(UserInsertDTO userInsertDTO) {
        return null;
    }

    @Override
    public User updateUser(UserUpdateDTO userUpdateDTO) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getUsersByLastname(String lastname) {
        return List.of();
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
