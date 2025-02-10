package gr.aueb.cf.inspirecraft.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductInsertDTO {

    @NotNull(message = "Product name must not be empty.")
    private String name;

    @NotNull(message = "Product description must not be empty.")
    private String description;

    @NotNull(message = "Creator details must not be null")
    private Creator creator;

    @NotNull(message = "Product image must not be empty.")
    private String imageUrl;

}
