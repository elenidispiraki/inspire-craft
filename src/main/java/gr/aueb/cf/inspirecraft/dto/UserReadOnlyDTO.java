package gr.aueb.cf.inspirecraft.dto;

import gr.aueb.cf.inspirecraft.core.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserReadOnlyDTO {
    private String username;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private Role role;
}
