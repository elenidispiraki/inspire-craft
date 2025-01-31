package gr.aueb.cf.inspirecraft.dto;

import gr.aueb.cf.inspirecraft.core.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserInsertDTO {

    @Email(message = "Invalid username. Username must be an email address.")
    @NotNull(message = "Username must not be empty.")
    private String username;

    @Pattern(regexp = "^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[!@#$%^&]).{8,}$", message = "Invalid password")
    private String password;

    @NotNull(message = "Firstname must not be empty.")
    private String firstname;

    @NotNull(message = "Lastname must not be empty.")
    private String lastname;

    private LocalDate dateOfBirth;

    @NotNull(message = "Role must not be empty.")
    private Role role;
}
