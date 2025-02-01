package gr.aueb.cf.inspirecraft.authentication;

import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectNotAuthorizedException;
import gr.aueb.cf.inspirecraft.dto.AuthenticationRequestDTO;
import gr.aueb.cf.inspirecraft.dto.AuthenticationResponseDTO;
import gr.aueb.cf.inspirecraft.model.User;
import gr.aueb.cf.inspirecraft.repositories.UserRepository;
import gr.aueb.cf.inspirecraft.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO dto)
            throws AppObjectNotAuthorizedException {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

        User user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new AppObjectNotAuthorizedException("User", "User not Authorized"));

        String token = jwtService.generateToken(authentication.getName(), user.getUsername());
        return new AuthenticationResponseDTO(user.getFirstname(), user.getLastname(), token);


    }


}
