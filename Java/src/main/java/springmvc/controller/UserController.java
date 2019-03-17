package springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(ModelMap model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}
	@RequestMapping(value = "/formSignUp", method = RequestMethod.POST)
	public String handleSignUp(@ModelAttribute("user") @Validated User user,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "signup";
		}
		else {
			userService.insertUser(user);
			model.addAttribute("nameUser", user.getName());
			return "loginsuccess";
		}
	}
	@RequestMapping(value = "/formLogin", method = RequestMethod.POST)
	public String handleLogin(ModelMap model, @RequestParam(name="emailUser") String email, @RequestParam(name="passwordUser") String password) {
		// đang bị lỗi nếu không tìm được user
		User user = userService.searchUser(new User(email, password));
		if(user != null) {
			model.addAttribute("nameUser", user.getName());
			return "loginsuccess";
		}
		else {
			return "NewFile";
		}
	}
	
	
	
}
