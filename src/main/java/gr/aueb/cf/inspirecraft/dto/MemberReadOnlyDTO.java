package gr.aueb.cf.inspirecraft.dto;

import gr.aueb.cf.inspirecraft.model.Favorites;
import gr.aueb.cf.inspirecraft.model.Product;
import gr.aueb.cf.inspirecraft.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberReadOnlyDTO extends UserReadOnlyDTO{
    private Long id;
    private User user;
    private Favorites favorites;
}
