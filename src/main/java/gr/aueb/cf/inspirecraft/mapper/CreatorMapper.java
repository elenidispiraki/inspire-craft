package gr.aueb.cf.inspirecraft.mapper;


import gr.aueb.cf.inspirecraft.dto.CreatorInsertDTO;
import gr.aueb.cf.inspirecraft.dto.CreatorReadOnlyDTO;
import gr.aueb.cf.inspirecraft.dto.CreatorUpdateDTO;
import gr.aueb.cf.inspirecraft.model.Creator;
import gr.aueb.cf.inspirecraft.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatorMapper {


    public Creator mapToCreatorEntity(CreatorInsertDTO creatorInsertDTO) {
        Creator creator = new Creator();
        creator.setUser(creatorInsertDTO.getUser());
        return creator;
    }

    public Creator mapToCreatorEntity(CreatorUpdateDTO creatorUpdateDTO) {
        Creator creator = new Creator();
        creator.setUser(creatorUpdateDTO.getUser());
        return creator;
    }

    public CreatorReadOnlyDTO mapToCreatorReadOnlyDTO(Creator creator) {
        CreatorReadOnlyDTO creatorReadOnlyDTO = new CreatorReadOnlyDTO();
        creatorReadOnlyDTO.setUser(creator.getUser());
        creatorReadOnlyDTO.setId(creator.getId());
        creatorReadOnlyDTO.setUuid(creator.getUuid());
        creatorReadOnlyDTO.setProducts(creator.getProducts());
        return creatorReadOnlyDTO;
    }







}
