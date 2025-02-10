package gr.aueb.cf.inspirecraft.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {

    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private String username;
    @NotNull
    private String password;

}
