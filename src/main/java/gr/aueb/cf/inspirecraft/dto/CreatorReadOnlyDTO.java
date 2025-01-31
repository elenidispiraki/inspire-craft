package gr.aueb.cf.inspirecraft.dto;

import gr.aueb.cf.inspirecraft.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreatorReadOnlyDTO extends UserReadOnlyDTO{
    private List<Product> products;
}
