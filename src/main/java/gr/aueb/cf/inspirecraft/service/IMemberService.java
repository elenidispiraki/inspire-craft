package gr.aueb.cf.inspirecraft.service;

import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectAlreadyExistsException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectInvalidArgumentException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectNotFoundException;
import gr.aueb.cf.inspirecraft.dto.MemberInsertDTO;
import gr.aueb.cf.inspirecraft.dto.MemberReadOnlyDTO;
import gr.aueb.cf.inspirecraft.dto.MemberUpdateDTO;
import gr.aueb.cf.inspirecraft.model.Member;
import gr.aueb.cf.inspirecraft.model.Product;

import java.util.List;

public interface IMemberService {
    MemberReadOnlyDTO saveMember(MemberInsertDTO MemberInsertDTO)
            throws AppObjectAlreadyExistsException, AppObjectInvalidArgumentException;
    MemberReadOnlyDTO updateMember(MemberUpdateDTO MemberUpdateDTO)
            throws AppObjectInvalidArgumentException, AppObjectNotFoundException;
    void deleteMember(Long id) throws AppObjectNotFoundException;
    List<Product> getFavoriteProductsByMemberId(Long id);
    void addProductToFavorites(Long memberId, Long productId);
    void removeProductFromFavorites(Long memberId, Long productId);
}
