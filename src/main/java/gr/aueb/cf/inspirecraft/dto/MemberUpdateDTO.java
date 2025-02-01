package gr.aueb.cf.inspirecraft.dto;

import gr.aueb.cf.inspirecraft.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MemberUpdateDTO extends UserUpdateDTO{
    private User user;
}
