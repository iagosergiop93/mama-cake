package com.cake.services;

import com.cake.dtos.UserDto;
import com.cake.entities.User;
import com.cake.exceptions.CustomException;
import com.cake.repositories.UserRepository;
import com.cake.utils.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepo = null;
    private Validation validation = null;

    @Autowired
    public UserService(UserRepository userRepo, Validation validation) {
        this.validation = validation;
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(long id) {
        return userRepo.findUserById(id);
    }

    public User login(String email, String passwd) {
        if(!validation.validateEmail(email) || !validation.validateNonEmptyString(passwd)) {
            throw new CustomException("Invalid inputs.", HttpStatus.BAD_REQUEST);
        }
        User user = null;
        try {
            user = userRepo.findUserByEmail(email);
        } catch (Exception e) {
            throw new CustomException("A problem happened.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(user == null || !checkPasswd(passwd, user.getPasswd())) throw new CustomException("The provided credentials don't match.", HttpStatus.FORBIDDEN);

        return user;
    }

    public User registerUser(UserDto userDto) {
        User user = new User(userDto);
        user.setPasswd(encriptPasswd(userDto.getPasswd()));
        user.setRoleId(1);
        if(!validation.validateUserFields(user)) throw new CustomException("Invalid fields", HttpStatus.BAD_REQUEST);

        try {
            user = userRepo.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new CustomException("This user already exist.", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new CustomException("A problem happened while registering the user", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(user == null) throw new CustomException("Invalid credential", HttpStatus.BAD_REQUEST);
        return user;
    }

    private String encriptPasswd(String passwd) {
        return BCrypt.hashpw(passwd, BCrypt.gensalt(10));
    }

    private boolean checkPasswd(String passwd, String hash) {
        return BCrypt.checkpw(passwd, hash);
    }

}
