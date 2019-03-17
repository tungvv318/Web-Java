package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;


@Controller
public class hello {
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hi() {
		return "signup";	
	}
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	public String ok(@RequestParam(name="emailUser") String email, @RequestParam(name="passwordUser") String password) {
		if(email.equals("tungvu@gmail.com")) {
			if(password.equals("123456")){
				return "NewFile";
			}
			else {
				return "";
			}
		}
		return "";
	}
}
