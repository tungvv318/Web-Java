package springmvc.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import springmvc.model.User;
import springmvc.service.UserService;

@Component
public class UserFormValidator implements Validator {
	@Autowired
	private UserService userService;

	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	// hàm kiểm tra số phone nhập vào có đúng 10 ký tự hay không?
	public boolean checkPhone(String s) {
		if (s.length() != 10) {
			return false;
		} else {
			for (int i = 0; i < s.length(); i++) {
				char check = s.charAt(i);
				if (!(check >= 48 && check <= 57)) {
					return false;
				}
			}
		}
		return true;
	}

	// hàm kiểm tra số ký tự của password có đúng hơn 6 ký tự hay không?
	public boolean checkLengthOfPassword(String s) {
		if (s.length() < 6) {
			return false;
		}
		return true;
	}

	public void validate(Object target, Errors errors) {
		User user = (User) target;
		/*
		 * lấy rePassword là điều kiện so sánh vì khi đăng nhập chỉ tìm user dựa trên email và password
		 */
		if (user.getRePassword() != null) {
			if (!user.getPassword().equals(user.getRePassword())) {
				errors.rejectValue("rePassword", "Diff.signup.rePassword");
			}
			if (checkPhone(user.getPhone()) == false) {
				errors.rejectValue("phone", "CheckPhone.signup.phone");
			}
			if (checkLengthOfPassword(user.getPassword()) == false) {
				errors.rejectValue("password", "CheckLength.signup.password");
			}
			if (userService.searchUserByEmail(user.getEmail()) != null) {
				errors.rejectValue("email", "Empty.signup.email");
			}
		} else {
			if (userService.searchUserInDatabase(user) == null) {
				errors.rejectValue("email", "False.signup.email");
			}
		}

	}
}
