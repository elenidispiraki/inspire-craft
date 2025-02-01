package gr.aueb.cf.inspirecraft.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequestDTO {

    @NotNull
    private String username;
    @NotNull
    private String password;
}
