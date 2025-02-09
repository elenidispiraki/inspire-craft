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
        product.setImageUrl(productInsertDTO.getImageUrl());
        return product;
    }

    public Product mapToProductEntity(ProductUpdateDTO productUpdateDTO) {
        Product product = new Product();
        product.setName(productUpdateDTO.getName());
        product.setDescription(productUpdateDTO.getDescription());
        product.setImageUrl(productUpdateDTO.getImageUrl());
        return product;
    }

    public ProductReadOnlyDTO mapToProductReadOnlyDTO(Product product) {
        ProductReadOnlyDTO productReadOnlyDTO = new ProductReadOnlyDTO();
        productReadOnlyDTO.setName(product.getName());
        productReadOnlyDTO.setDescription(product.getDescription());
        productReadOnlyDTO.setCreator(product.getCreator());
        productReadOnlyDTO.setImageUrl(product.getImageUrl());
        return productReadOnlyDTO;
    }


}
