package gr.aueb.cf.inspirecraft.mapper;

import gr.aueb.cf.inspirecraft.dto.UserInsertDTO;
import gr.aueb.cf.inspirecraft.dto.UserReadOnlyDTO;
import gr.aueb.cf.inspirecraft.dto.UserUpdateDTO;
import gr.aueb.cf.inspirecraft.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public User mapToUserEntity(UserInsertDTO userInsertDTO) {
        User user = new User();
        user.setUsername(userInsertDTO.getUsername());
        user.setPassword(userInsertDTO.getPassword());
        user.setFirstname(userInsertDTO.getFirstname());
        user.setLastname(userInsertDTO.getLastname());
        user.setRole(userInsertDTO.getRole());

        return user;
    }

    public User mapToUserEntity(UserUpdateDTO userUpdateDTO) {
        User user = new User();
        user.setUsername(userUpdateDTO.getUsername());
        user.setPassword(userUpdateDTO.getPassword());
        user.setFirstname(userUpdateDTO.getFirstname());
        user.setLastname(userUpdateDTO.getLastname());
        user.setRole(userUpdateDTO.getRole());

        return user;
    }

    public UserReadOnlyDTO mapToUserReadOnlyDTO(User user) {
        UserReadOnlyDTO userReadOnlyDTO = new UserReadOnlyDTO();

        userReadOnlyDTO.setUsername(user.getUsername());
        userReadOnlyDTO.setFirstname(user.getFirstname());
        userReadOnlyDTO.setLastname(user.getLastname());
        userReadOnlyDTO.setRole(user.getRole());

        return userReadOnlyDTO;
    }

}
