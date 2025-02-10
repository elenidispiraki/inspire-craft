package gr.aueb.cf.inspirecraft.dto;

import gr.aueb.cf.inspirecraft.core.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserUpdateDTO {

    @Email(message = "Invalid username. Username must be an email address.")
    private String username;

    @Pattern(regexp = "^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[!@#$%^&]).{8,}$", message = "Invalid password")
    private String password;

    private String firstname;
    private String lastname;
    private Role role;

}
