package com.cake.utils;

import com.cake.entities.User;
import org.springframework.stereotype.Component;

@Component
public class Validation {

    public boolean validateUserFields(User user) {
        if(!validateNonEmptyString(user.getFirstName())) return false;
        if(!validateNonEmptyString(user.getLastName())) return false;
        if(!validateEmail(user.getEmail())) return false;
        if(!validateNonEmptyString(user.getPasswd())) return false;

        return true;
    }

    public boolean validateEmail(String email) {
        return validateNonEmptyString(email) || email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }

    public boolean validateNonEmptyString(String str) {
        return !(str == null || str.equals(""));
    }

}
