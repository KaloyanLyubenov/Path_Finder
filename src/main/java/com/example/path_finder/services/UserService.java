package com.example.path_finder.services;

import com.example.path_finder.domain.dto.bading.RoleChangeForm;
import com.example.path_finder.domain.dto.bading.UserLoginForm;
import com.example.path_finder.domain.dto.bading.UserRegisterForm;
import com.example.path_finder.domain.dto.models.UserModel;
import com.example.path_finder.domain.entities.Role;
import com.example.path_finder.domain.entities.User;
import com.example.path_finder.domain.enums.Levels;
import com.example.path_finder.domain.enums.Roles;
import com.example.path_finder.helpers.LoggedUser;
import com.example.path_finder.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    @Autowired
    public UserService(UserRepository userRepository, RoleService    roleService, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    public void registerUser(UserRegisterForm userRegister){
        final UserModel userModel = this.modelMapper.map(userRegister, UserModel.class);

        userModel.setRoles(this.userRepository.count() == 0
                ? this.roleService.findAllRoles()
                : Set.of(this.roleService.findRoleByName("USER")));

        final User userToSave = this.modelMapper.map(userModel, User.class).setLevel(Levels.BEGINNER);

        this.modelMapper.map(this.userRepository.saveAndFlush(userToSave), UserModel.class);
    }

    public UserModel loginUser(UserLoginForm userLogin) {
        Optional<User> loginCandidate = this.userRepository.findByUsername(userLogin.username());

        UserModel userConfirmation = loginCandidate.isPresent()
                && loginCandidate.get().getPassword().equals(userLogin.password())
                ? this.modelMapper.map(loginCandidate.get(), UserModel.class)
                : new UserModel();

        if (userConfirmation.isValid()) {
            this.loggedUser
                    .setId(userConfirmation.getId())
                    .setUsername(userConfirmation.getUsername())
                    .setRoleModels(userConfirmation.getRoles());
        }

        return userConfirmation;
    }

    public void logout() {
        this.loggedUser.clearFields();
    }

    public Set<Roles> changeUserPermissions(Long userId,
                                            RoleChangeForm roleModelToSet,
                                            boolean shouldReplaceCurrentRoles){

        User user = this.userRepository.findById(userId).orElseThrow(NoSuchElementException::new);

        final Role roleToSave = this.modelMapper.map(this.roleService.findRoleByName(roleModelToSet.roleName()), Role.class);

        if(shouldReplaceCurrentRoles){
            user.setRoles(Set.of(roleToSave));
        }else{
            user.getRoles().add(roleToSave);
        }

        this.userRepository.saveAndFlush(user);

        return user.getRoles().stream().map(Role::getRole).collect(Collectors.toSet());
    }

}
