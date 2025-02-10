package gr.aueb.cf.inspirecraft.rest;

import gr.aueb.cf.inspirecraft.authentication.AuthenticationService;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectNotAuthorizedException;
import gr.aueb.cf.inspirecraft.dto.AuthenticationRequestDTO;
import gr.aueb.cf.inspirecraft.dto.AuthenticationResponseDTO;
import gr.aueb.cf.inspirecraft.dto.RegisterRequestDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthRestController.class);
    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(@RequestBody AuthenticationRequestDTO authenticationRequestDTO)
    throws AppObjectNotAuthorizedException {
        AuthenticationResponseDTO authenticationResponseDTO = authenticationService.authenticate(authenticationRequestDTO);
        LOGGER.info("User Authenticated");
        return new ResponseEntity<>(authenticationResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        AuthenticationResponseDTO responseDTO = authenticationService.register(registerRequestDTO);
        LOGGER.info("New User Registered: {}", registerRequestDTO.getUsername());
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }



}
