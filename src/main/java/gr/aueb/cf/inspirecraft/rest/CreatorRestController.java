package gr.aueb.cf.inspirecraft.rest;

import gr.aueb.cf.inspirecraft.core.exceptions.*;
import gr.aueb.cf.inspirecraft.dto.CreatorInsertDTO;
import gr.aueb.cf.inspirecraft.dto.CreatorReadOnlyDTO;
import gr.aueb.cf.inspirecraft.dto.CreatorUpdateDTO;
import gr.aueb.cf.inspirecraft.mapper.CreatorMapper;
import gr.aueb.cf.inspirecraft.model.Creator;
import gr.aueb.cf.inspirecraft.repositories.CreatorRepository;
import gr.aueb.cf.inspirecraft.service.CreatorServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CreatorRestController {

    private final CreatorServiceImpl creatorService;
    private final CreatorRepository creatorRepository;
    private final CreatorMapper creatorMapper;

    @GetMapping("/creators")
    public ResponseEntity<List<Creator>> getCreators(){
        List<Creator> creators = creatorService.getCreators();
        return new ResponseEntity<>(creators, HttpStatus.OK);
    }

    @GetMapping("/creators/{id}")
    public ResponseEntity<CreatorReadOnlyDTO>  getCreatorById(@PathVariable Long id)
            throws AppObjectNotFoundException {

        CreatorReadOnlyDTO creatorReadOnlyDTO =
                creatorService.getCreator(id)
                        .orElseThrow(() -> new AppObjectNotFoundException("Creator", "Creator " +
                                "with id: " + id + " not found"));
        return new ResponseEntity<>(creatorReadOnlyDTO, HttpStatus.OK);
    }

    @PostMapping("/creators/save")
    public ResponseEntity<CreatorReadOnlyDTO> saveCreator(
            @Valid @RequestBody CreatorInsertDTO creatorInsertDTO,
            BindingResult bindingResult)
            throws AppObjectInvalidArgumentException, AppValidationException, AppServerException, AppObjectAlreadyExistsException {
        if(bindingResult.hasErrors()) {
            throw new AppValidationException(bindingResult);
        }
        CreatorReadOnlyDTO creatorReadOnlyDTO = creatorService.saveCreator(creatorInsertDTO);
        return new ResponseEntity<>(creatorReadOnlyDTO, HttpStatus.OK);
    }

    @PostMapping("/creators/update")
    public ResponseEntity<CreatorReadOnlyDTO> updateCreator(
            @Valid @RequestBody CreatorUpdateDTO creatorUpdateDTO,
            BindingResult bindingResult)
            throws AppObjectInvalidArgumentException,
            AppValidationException,
            AppObjectNotFoundException {
        if (bindingResult.hasErrors()) {
            throw new AppValidationException(bindingResult);
        }
        CreatorReadOnlyDTO updatedCreator = creatorService.updateCreator(creatorUpdateDTO);
        return new ResponseEntity<>(updatedCreator, HttpStatus.OK);
    }

    @DeleteMapping("/creators/delete")
    public ResponseEntity<Void> deleteCreator(@PathVariable Long id) throws AppObjectNotFoundException{
        creatorService.deleteCreator(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
