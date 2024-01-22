package sandoval.john.server.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sandoval.john.server.models.User;

@Component
public class UserValidator implements Validator {
    
    //    1
    @Override
    public boolean supports(Class<?> c) { // Specifies that a instance of the User Domain Model can be validated with this custom validator
        return User.class.equals(c);
    }
    
    // 2
    @Override
    public void validate(Object object, Errors errors) {  // Creating our custom validation. We can add errors via .rejectValue(String, String)
        User user = (User) object;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) { // If the password and password confirmation do not match,
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }
}