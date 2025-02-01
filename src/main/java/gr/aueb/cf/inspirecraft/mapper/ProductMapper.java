package gr.aueb.cf.inspirecraft.mapper;

import gr.aueb.cf.inspirecraft.dto.ProductInsertDTO;
import gr.aueb.cf.inspirecraft.dto.ProductReadOnlyDTO;
import gr.aueb.cf.inspirecraft.dto.ProductUpdateDTO;
import gr.aueb.cf.inspirecraft.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    public Product mapToProductEntity(ProductInsertDTO productInsertDTO) {
        Product product = new Product();
        product.setName(productInsertDTO.getName());
        product.setDescription(productInsertDTO.getDescription());
        product.setCreator(productInsertDTO.getCreator());
        return product;
    }

    public Product mapToProductEntity(ProductUpdateDTO productUpdateDTO) {
        Product product = new Product();
        product.setName(productUpdateDTO.getName());
        product.setDescription(productUpdateDTO.getDescription());
        return product;
    }

    public ProductReadOnlyDTO mapToProductReadOnlyDTO(Product product) {
        ProductReadOnlyDTO productReadOnlyDTO = new ProductReadOnlyDTO();
        productReadOnlyDTO.setName(product.getName());
        productReadOnlyDTO.setDescription(product.getDescription());
        productReadOnlyDTO.setCreator(product.getCreator());
        return productReadOnlyDTO;
    }


}
