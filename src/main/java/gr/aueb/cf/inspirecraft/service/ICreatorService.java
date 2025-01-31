package gr.aueb.cf.inspirecraft.service;

import gr.aueb.cf.inspirecraft.model.Creator;

import java.util.List;
import java.util.Optional;

public interface ICreatorService {

    Creator saveCreator(CreatorInsertDTO creatorInsertDTO);
    Creator updateCreator(CreatorUpdateDTO creatorUpdateDTO);
    void deleteCreator(Long id);
    Optional<Creator> getCreatorByUsername(String Username);
    Optional<Creator> getCreatorById(Long id);
    List<Creator> getCreatorsByLastname(String lastname);
    List<Creator> getAllCreators();

}
