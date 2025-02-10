package gr.aueb.cf.inspirecraft.rest;

import gr.aueb.cf.inspirecraft.core.exceptions.*;
import gr.aueb.cf.inspirecraft.dto.*;
import gr.aueb.cf.inspirecraft.mapper.UserMapper;
import gr.aueb.cf.inspirecraft.model.User;
import gr.aueb.cf.inspirecraft.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserRestController {

    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    @GetMapping("/users/{id}")
    public ResponseEntity<UserReadOnlyDTO>  getUserById(@PathVariable Long id)
            throws AppObjectNotFoundException {
        User user = userService.getUserById(id)
                .orElseThrow(()-> new AppObjectNotFoundException("User", "User with id: " + id + " not found"));
        UserReadOnlyDTO userReadOnlyDTO = userMapper.mapToUserReadOnlyDTO(user);
        return new ResponseEntity<>(userReadOnlyDTO, HttpStatus.OK);
    }

    @GetMapping("/users/all")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/users/save")
    public ResponseEntity<UserReadOnlyDTO> saveUser(@Valid @RequestBody UserInsertDTO userInsertDTO,
                                                    BindingResult bindingResult)
            throws AppObjectInvalidArgumentException,
            AppValidationException,
            AppObjectAlreadyExistsException {

        if(bindingResult.hasErrors()) {
            throw new AppValidationException(bindingResult);
        }
        UserReadOnlyDTO userReadOnlyDTO = userService.saveUser(userInsertDTO);
        return new ResponseEntity<>(userReadOnlyDTO, HttpStatus.OK);
    }

    @PutMapping("/users/update")
    public ResponseEntity<UserReadOnlyDTO> updateUser(
            @Valid @RequestBody UserUpdateDTO userUpdateDTO,
            BindingResult bindingResult)
            throws AppObjectInvalidArgumentException,
            AppValidationException,
            AppObjectNotFoundException {
        if (bindingResult.hasErrors()) {
            throw new AppValidationException(bindingResult);
        }
        UserReadOnlyDTO updatedUser = userService.updateUser(userUpdateDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}/delete")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws AppObjectNotFoundException  {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
