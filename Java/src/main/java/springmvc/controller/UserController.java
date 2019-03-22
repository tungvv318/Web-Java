package springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.validator.UserFormValidator;
import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	UserFormValidator userFormValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}

	// hàm dùng để vào trang đăng kí
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(ModelMap model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	// hàm dùng để vào trang đăng nhập
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("user", new User(null, null));
		return "login";
	}

	// hàm xử lý đăng kí
	@RequestMapping(value = "/formSignUp", method = RequestMethod.POST)
	public String handleSignUp(@ModelAttribute("user") @Validated User user, BindingResult result, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "signup";
		} else {
			userService.insertUser(user);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			model.addAttribute("nameUser", user.getName());
			return "loginsuccess";

		}
	}

	// hàm xử lý đăng nhập
	@RequestMapping(value = "/formLogin", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("user") @Validated User user, BindingResult result, Model model,
			HttpServletRequest request) {
		// kiểm tra email và pass ở dưới database, đúng thì cho đăng nhập sai thì thôi

		if (result.hasErrors()) {
			return "login";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			User userFind = userService.searchUserInDatabase(user);
			model.addAttribute("nameUser", user.getName());
			return "loginsuccess";
		}
	}

}
