package gr.aueb.cf.inspirecraft.dto;

import gr.aueb.cf.inspirecraft.core.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserReadOnlyDTO {
    private String username;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private Role role;
}
