package gr.aueb.cf.inspirecraft.service;

import gr.aueb.cf.inspirecraft.dto.ProductInsertDTO;
import gr.aueb.cf.inspirecraft.dto.ProductUpdateDTO;
import gr.aueb.cf.inspirecraft.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Product saveProduct(ProductInsertDTO productInsertDTO);
    Product updateProduct(ProductUpdateDTO productUpdateDTO);
    void deleteProduct(Long id);
    Optional<Product> getProductById(Long id);
    List<Product> getProductsByName(String name);
    List<Product> getAllProducts();

}
