package gr.aueb.cf.inspirecraft.service;

import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectAlreadyExistsException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectInvalidArgumentException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectNotFoundException;
import gr.aueb.cf.inspirecraft.dto.UserInsertDTO;
import gr.aueb.cf.inspirecraft.dto.UserReadOnlyDTO;
import gr.aueb.cf.inspirecraft.dto.UserUpdateDTO;
import gr.aueb.cf.inspirecraft.mapper.Mapper;
import gr.aueb.cf.inspirecraft.model.User;
import gr.aueb.cf.inspirecraft.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {


    private final UserRepository userRepository;
    private final Mapper mapper;


    @Transactional(rollbackOn = Exception.class)
    public UserReadOnlyDTO saveUser(UserInsertDTO userInsertDTO) throws AppObjectAlreadyExistsException,
            AppObjectInvalidArgumentException {

        if(userRepository.findByUsername(userInsertDTO.getUsername()).isPresent()) {
            throw new AppObjectAlreadyExistsException("User", "User with username: " + userInsertDTO.getUsername()+
                    " already exists") ;
        }
        User user = mapper.mapToUserEntity(userInsertDTO);
        User savedUser = userRepository.save(user);
        return mapper.mapToUserReadOnlyDTO(savedUser);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public UserReadOnlyDTO updateUser(UserUpdateDTO userUpdateDTO)
            throws AppObjectInvalidArgumentException, AppObjectNotFoundException {
        User user = mapper.mapToUserEntity(userUpdateDTO);
        if(userRepository.findById(user.getId()).isEmpty()) {
            throw new AppObjectNotFoundException("User", "User with id: " + user.getId()+ " not " +
                    "found") ;
        }
        User savedUser = userRepository.save(user);
        return mapper.mapToUserReadOnlyDTO(savedUser);
    }


    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteUser(Long id) throws AppObjectNotFoundException {
        if(userRepository.findById(id).isEmpty()) {
            throw new AppObjectNotFoundException("User", "User with id: " + id + " not " +
                    "found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getUsersByLastname(String lastname) {
        return userRepository.findByLastname(lastname);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
