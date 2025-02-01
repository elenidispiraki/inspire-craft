package gr.aueb.cf.inspirecraft.dto;

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
public class CreatorReadOnlyDTO extends UserReadOnlyDTO{
    private Long id;
    private String uuid;
    private User user;
    private List<Product> products;
}
