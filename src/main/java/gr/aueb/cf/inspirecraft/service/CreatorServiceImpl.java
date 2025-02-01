package gr.aueb.cf.inspirecraft.service;

import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectAlreadyExistsException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectInvalidArgumentException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectNotFoundException;
import gr.aueb.cf.inspirecraft.dto.CreatorInsertDTO;
import gr.aueb.cf.inspirecraft.dto.CreatorReadOnlyDTO;
import gr.aueb.cf.inspirecraft.dto.CreatorUpdateDTO;
import gr.aueb.cf.inspirecraft.mapper.CreatorMapper;
import gr.aueb.cf.inspirecraft.model.Creator;
import gr.aueb.cf.inspirecraft.model.Product;
import gr.aueb.cf.inspirecraft.repositories.CreatorRepository;
import gr.aueb.cf.inspirecraft.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreatorServiceImpl implements ICreatorService {

    private final UserRepository userRepository;
    private final CreatorRepository creatorRepository;
    private final CreatorMapper creatorMapper;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public CreatorReadOnlyDTO saveCreator(CreatorInsertDTO creatorInsertDTO)
            throws AppObjectAlreadyExistsException, AppObjectInvalidArgumentException {

        if (creatorRepository.findById(creatorInsertDTO.getUser().getId()).isPresent()){
            throw new AppObjectAlreadyExistsException("Creator", "Creator already exists");
        }
        if (userRepository.findByUsername(creatorInsertDTO.getUser().getUsername()).isPresent()){
            throw new AppObjectAlreadyExistsException("Creator", "Creator already exists");
        }

        Creator creator = creatorMapper.mapToCreatorEntity(creatorInsertDTO);
        Creator savedCreator = creatorRepository.save(creator);
        return creatorMapper.mapToCreatorReadOnlyDTO(savedCreator);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public CreatorReadOnlyDTO updateCreator(CreatorUpdateDTO creatorUpdateDTO) throws AppObjectInvalidArgumentException,
            AppObjectNotFoundException {

        if (userRepository.findById(creatorUpdateDTO.getUser().getId()).isEmpty()){
            throw new AppObjectNotFoundException("Creator", "Creator not found");
        }
        Creator creator = creatorMapper.mapToCreatorEntity(creatorUpdateDTO);
        Creator savedCreator = creatorRepository.save(creator);
        return creatorMapper.mapToCreatorReadOnlyDTO(savedCreator);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteCreator(Long id) throws AppObjectNotFoundException {
        creatorRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductsByCreatorId(Long creatorId) {
        return creatorRepository.findById(creatorId).get().getProducts();
    }
}
