package cl.medicapp.service.security;

import cl.medicapp.service.entity.UserEntity;
import cl.medicapp.service.repository.UserRepository;
import cl.medicapp.service.util.UserDetailsUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Clase implementación de UserDetailsService
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Carga el usuario a logearse
     *
     * @param username Nombre de usuario
     * @return UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        log.info("Inicializado por {}", username);
        Optional<UserEntity> userOptional = userRepository.findByEmailIgnoreCaseAndEnabledTrue(username);
        return UserDetailsUtil.build(userOptional.orElseThrow(() -> new UsernameNotFoundException(username.concat(" not found"))));
    }

}