package gr.aueb.cf.inspirecraft.authentication;

import gr.aueb.cf.inspirecraft.core.enums.Role;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectNotAuthorizedException;
import gr.aueb.cf.inspirecraft.dto.AuthenticationRequestDTO;
import gr.aueb.cf.inspirecraft.dto.AuthenticationResponseDTO;
import gr.aueb.cf.inspirecraft.dto.RegisterRequestDTO;
import gr.aueb.cf.inspirecraft.model.User;
import gr.aueb.cf.inspirecraft.repositories.UserRepository;
import gr.aueb.cf.inspirecraft.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO dto)
            throws AppObjectNotAuthorizedException {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

        User user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new AppObjectNotAuthorizedException("User", "User not Authorized"));

        String token = jwtService.generateToken(authentication.getName(), user.getUsername());
        return new AuthenticationResponseDTO(user.getFirstname(), user.getLastname(), user.getUsername(),
                 user.getRole().toString(),token);


    }

    public AuthenticationResponseDTO register(RegisterRequestDTO dto) {
        // Δημιουργία χρήστη
        User user = new User();
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(Role.CREATOR);


        System.out.println("User object before save: " + user);

        userRepository.save(user);

        // Δημιουργία JWT Token
        String token = jwtService.generateToken(user.getUsername(), user.getRole().name());

        return new AuthenticationResponseDTO(user.getFirstname(), user.getLastname(), user.getUsername(),
                user.getRole().toString(),
                token);
    }


}
