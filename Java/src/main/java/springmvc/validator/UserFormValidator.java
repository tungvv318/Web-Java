package springmvc.validator;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springmvc.model.User;

@Component
public class UserFormValidator implements Validator{
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
	}
}
