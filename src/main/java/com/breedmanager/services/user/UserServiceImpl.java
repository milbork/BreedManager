package com.breedmanager.services.user;

import com.breedmanager.model.DTO.UserDTO;
import com.breedmanager.model.Role;
import com.breedmanager.model.User;
import com.breedmanager.repositories.RoleRepository;
import com.breedmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = {"userCache"})
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public void createUser(UserDTO userDTO) {
        User user = new User();
        userRepository.save(createOrEditUser(user, userDTO));
    }

    @Override
    public void editProfile(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        createOrEditUser(user, userDTO);
        userRepository.save(user);
    }

    private User createOrEditUser(User user, UserDTO userDTO) {
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setFunction(userDTO.getFunction());
        if (userDTO.getFunction().equals("owner")) {
            Role userRole = roleRepository.findByName("ROLE_USER");
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        } else if (userDTO.getFunction().equals("breeder")) {
            Role userRole = roleRepository.findByName("ROLE_BREEDER");
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        }
        user.setEnabled(1);
        return user;
    }

    @Override
    public boolean checkIfUserAlreadyExist(UserDTO user) {
        Optional<User> optional = Optional.ofNullable(userRepository.findUserByEmail(user.getEmail()));
        return optional.isPresent();

    }
    @Override
    public boolean checkIfEmailIsAlreadyUsed(String currentEmail, UserDTO userDTO){

        if (currentEmail.equalsIgnoreCase(userDTO.getEmail())) {
            return false ;
        } else {
            return checkIfUserAlreadyExist(userDTO);
        }
    }

    @Override
    public void removeUser(Long id) {
        userRepository.delete(userRepository.getOne(id));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findUserById(id);
    }

}
