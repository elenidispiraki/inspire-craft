package gr.aueb.cf.inspirecraft.rest;

import gr.aueb.cf.inspirecraft.core.exceptions.*;
import gr.aueb.cf.inspirecraft.dto.ProductInsertDTO;
import gr.aueb.cf.inspirecraft.dto.ProductReadOnlyDTO;
import gr.aueb.cf.inspirecraft.dto.ProductUpdateDTO;
import gr.aueb.cf.inspirecraft.mapper.ProductMapper;
import gr.aueb.cf.inspirecraft.model.Product;
import gr.aueb.cf.inspirecraft.service.ProductServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductServiceImpl productService;
    private final ProductMapper productMapper;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductReadOnlyDTO> getProductById(@PathVariable Long id)
            throws AppObjectNotFoundException {

        ProductReadOnlyDTO product = productMapper
                .mapToProductReadOnlyDTO(productService.getProductById(id)
                        .orElseThrow(() -> new AppObjectNotFoundException("Product", "Product not found")));
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/products/save")
    public ResponseEntity<ProductReadOnlyDTO> createProduct(
            @Valid @RequestBody ProductInsertDTO productInsertDTO,
            BindingResult bindingResult)
            throws AppValidationException,
            AppObjectAlreadyExistsException {
        if (bindingResult.hasErrors()) {
            throw new AppValidationException(bindingResult);
        }
        ProductReadOnlyDTO product = productService.saveProduct(productInsertDTO);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/products/update")
    public ResponseEntity<ProductReadOnlyDTO> updateProduct(
            @Valid @RequestBody ProductUpdateDTO productUpdateDTO,
            BindingResult bindingResult)
            throws AppObjectNotFoundException,
            AppValidationException{
        if (bindingResult.hasErrors()) {
            throw new AppValidationException(bindingResult);
        }
        ProductReadOnlyDTO product = productService.updateProduct(productUpdateDTO);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{id}/delete")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) throws AppObjectNotFoundException {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
