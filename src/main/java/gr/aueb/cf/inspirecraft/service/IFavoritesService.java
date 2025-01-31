package gr.aueb.cf.inspirecraft.service;

import gr.aueb.cf.inspirecraft.model.Favorites;
import gr.aueb.cf.inspirecraft.model.Member;
import gr.aueb.cf.inspirecraft.model.Product;

public interface IFavoritesService {
    Favorites createFavoritesForMember(Member member);
    void deleteFavorites(Long id);
    Favorites addProductToFavoritesForMember(Member member, Product product);
    Favorites removeProductFromFavoritesForMember(Member member, Product product);
    Favorites getFavoritesForMember(Member member);
}
