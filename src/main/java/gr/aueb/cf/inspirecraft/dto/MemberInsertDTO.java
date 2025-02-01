package gr.aueb.cf.inspirecraft.dto;

import gr.aueb.cf.inspirecraft.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MemberInsertDTO{

    @NotNull(message = "User details must not be null")
    private User user;

}
