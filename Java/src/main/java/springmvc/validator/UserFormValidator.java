package springmvc.validator;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springmvc.model.User;
import springmvc.service.UserService;
import springmvc.service.UserServiceImpl;

@Component
public class UserFormValidator implements Validator{
	@Autowired
	private UserService userService;
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	public boolean checkString(String s) {
		if(s.length() != 10) {
			return false;
		}
		else {
			for(int i = 0; i < s.length(); i++) {
				char check = s.charAt(i);
				if(!(check >= 48 && check <= 57)) {
					return false;
				}
			}
		}
		return true;
	}
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if (!user.getPassword().equals(user.getRePassword())) {
			errors.rejectValue("rePassword", "Diff.signup.rePassword");
		}
		if (checkString(user.getPhone())==false) {
			errors.rejectValue("phone", "Diff.signup.phone");
		}
		if(userService.searchUserByEmail(user.getEmail())!=null) {
			errors.rejectValue("email", "Empty.signup.email");
		}
		if(userService.searchUserInDatabase(user)==null) {
			errors.rejectValue("email", "False.signup.email");
		}
	}
}
