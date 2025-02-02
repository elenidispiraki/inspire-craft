package gr.aueb.cf.inspirecraft.service;

import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectAlreadyExistsException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectInvalidArgumentException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectNotFoundException;
import gr.aueb.cf.inspirecraft.dto.CreatorInsertDTO;
import gr.aueb.cf.inspirecraft.dto.CreatorReadOnlyDTO;
import gr.aueb.cf.inspirecraft.dto.CreatorUpdateDTO;
import gr.aueb.cf.inspirecraft.model.Creator;
import gr.aueb.cf.inspirecraft.model.Product;
import java.util.List;
import java.util.Optional;


public interface ICreatorService {

    CreatorReadOnlyDTO saveCreator(CreatorInsertDTO CreatorInsertDTO)
            throws AppObjectAlreadyExistsException, AppObjectInvalidArgumentException;
    CreatorReadOnlyDTO updateCreator(CreatorUpdateDTO CreatorUpdateDTO)
            throws AppObjectInvalidArgumentException, AppObjectNotFoundException;
    void deleteCreator(Long id) throws AppObjectNotFoundException;
    List<Product> getProductsByCreatorId(Long creatorId);
    List<Creator> getCreators();
    Optional<CreatorReadOnlyDTO> getCreator(Long id) throws AppObjectNotFoundException;

}
