package gr.aueb.cf.inspirecraft.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductReadOnlyDTO {
    private String name;
    private String description;
    private String imageUrl;
}
