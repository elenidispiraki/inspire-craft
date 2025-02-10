package gr.aueb.cf.inspirecraft.service;

import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectAlreadyExistsException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectNotFoundException;
import gr.aueb.cf.inspirecraft.dto.ProductInsertDTO;
import gr.aueb.cf.inspirecraft.dto.ProductReadOnlyDTO;
import gr.aueb.cf.inspirecraft.dto.ProductUpdateDTO;
import gr.aueb.cf.inspirecraft.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    ProductReadOnlyDTO saveProduct(ProductInsertDTO productInsertDTO) throws AppObjectAlreadyExistsException;
    ProductReadOnlyDTO updateProduct(ProductUpdateDTO productUpdateDTO) throws AppObjectNotFoundException;
    void deleteProduct(Long id) throws AppObjectNotFoundException;
    Optional<Product> getProductById(Long id) throws AppObjectNotFoundException;
    List<Product> getAllProducts();

}
