package gr.aueb.cf.inspirecraft.service;

import gr.aueb.cf.inspirecraft.model.Product;

import java.util.List;

public interface IMemberService extends IUserService{
    List<Product> getFavoriteProductsByMemberId(Long id);
    void addProductToFavorites(Long memberId, Long productId);
    void removeProductFromFavorites(Long memberId, Long productId);
}
