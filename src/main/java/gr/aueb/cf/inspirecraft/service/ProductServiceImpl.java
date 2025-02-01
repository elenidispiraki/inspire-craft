package gr.aueb.cf.inspirecraft.service;

import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectAlreadyExistsException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectNotFoundException;
import gr.aueb.cf.inspirecraft.dto.ProductInsertDTO;
import gr.aueb.cf.inspirecraft.dto.ProductReadOnlyDTO;
import gr.aueb.cf.inspirecraft.dto.ProductUpdateDTO;
import gr.aueb.cf.inspirecraft.mapper.ProductMapper;
import gr.aueb.cf.inspirecraft.model.Product;
import gr.aueb.cf.inspirecraft.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ProductReadOnlyDTO saveProduct(ProductInsertDTO productInsertDTO) throws AppObjectAlreadyExistsException {
        Product product = productMapper.mapToProductEntity(productInsertDTO);
        if (productRepository.findById(product.getId()).isPresent()) {
            throw new AppObjectAlreadyExistsException("Product", "Product already exists");
        }
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToProductReadOnlyDTO(savedProduct);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ProductReadOnlyDTO updateProduct(ProductUpdateDTO productUpdateDTO) throws AppObjectNotFoundException {
        Product product = productMapper.mapToProductEntity(productUpdateDTO);
        if (productRepository.findById(product.getId()).isPresent()){
            throw new AppObjectNotFoundException("Product", "Product not found");
        }
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToProductReadOnlyDTO(savedProduct);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
