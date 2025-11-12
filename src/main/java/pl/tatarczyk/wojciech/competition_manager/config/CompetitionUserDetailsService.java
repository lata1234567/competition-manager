package pl.tatarczyk.wojciech.competition_manager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.tatarczyk.wojciech.competition_manager.repository.UserRepository;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.RoleEntity;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.UserEntity;

import java.util.Set;
import java.util.logging.Logger;

@Service
public class CompetitionUserDetailsService implements UserDetailsService {
    private static final Logger LOGGER = Logger.getLogger(CompetitionUserDetailsService.class.getName());

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("loadUserByUsername("+username+")");

        if(username == null){
            throw new UsernameNotFoundException("unable to find user with name " + username);
        }

        UserEntity userEntity = userRepository.findByLogin(username);

        Set<RoleEntity> roles = userEntity.getRoles();
        String[] roleNames = new String[roles.size()];
        int index = 0;
        for(RoleEntity roleEntity : roles){
            roleNames[index] = roleEntity.getName();
            index++;
        }

        UserDetails userDetails = User.withUsername(userEntity.getLogin())
                .password(userEntity.getPassword())
                .roles(roleNames)
                .build();

        LOGGER.info("loadUserByUsername(...) = " + userDetails);

        return userDetails;
    }
}
