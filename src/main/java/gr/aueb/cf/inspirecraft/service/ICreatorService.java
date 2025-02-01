package gr.aueb.cf.inspirecraft.service;

import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectAlreadyExistsException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectInvalidArgumentException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectNotFoundException;
import gr.aueb.cf.inspirecraft.dto.CreatorInsertDTO;
import gr.aueb.cf.inspirecraft.dto.CreatorUpdateDTO;
import gr.aueb.cf.inspirecraft.model.Creator;
import gr.aueb.cf.inspirecraft.model.Product;
import java.util.List;


public interface ICreatorService {

    Creator saveCreator(CreatorInsertDTO CreatorInsertDTO)
            throws AppObjectAlreadyExistsException, AppObjectInvalidArgumentException;
    Creator updateCreator(CreatorUpdateDTO CreatorUpdateDTO)
            throws AppObjectInvalidArgumentException, AppObjectNotFoundException;
    void deleteCreator(Long id) throws AppObjectNotFoundException;
    List<Product> getProductsByCreatorId(Long creatorId);

}
