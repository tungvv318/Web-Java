package springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import springmvc.validator.UserFormValidator;
import springmvc.model.Category;
import springmvc.model.User;
import springmvc.service.ProductService;
import springmvc.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	UserFormValidator userFormValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String homePage(ModelMap model, HttpServletRequest request) {
		List<Category> lstCategory = productService.getListCategory();
		model.addAttribute("lstCategory", lstCategory);
		
		return "index";
	}
	/**
	 * hàm dùng để vào trang đăng kí
	 * 
	 * @param model: dùng để đẩy user vào modelAttribute
	 * @return: chuyển màn hình thành trang đăng kí
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(ModelMap model) {
		/*
		 * - thêm một user rỗng vào form để khi nhập vào form chính là set giá trị các
		 * thuộc tính cho user rỗng này
		 * 
		 * - phải thêm user rỗng để dùng được validation
		 */

		model.addAttribute("user", new User());
		List<Category> lstCategory = productService.getListCategory();
		model.addAttribute("lstCategory", lstCategory);
		return "signup";
	}

	/**
	 * hàm dùng để vào trang đăng nhập
	 * 
	 * @param model: dùng để đẩy user vào modelAttribute
	 * @return: chuyển màn hình thành trang đăng nhập
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		/*
		 * - thêm một user có email = null, password = null vào form để khi nhập vào
		 * form chính là set giá trị các thuộc tính cho user rỗng này
		 * 
		 * - phải thêm user rỗng để dùng được validation
		 */
		model.addAttribute("user", new User(null, null));
		List<Category> lstCategory = productService.getListCategory();
		model.addAttribute("lstCategory", lstCategory);
		return "login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("userName");
		return "redirect:/index";
	}

	/**
	 * hàm xử lý tác vụ đăng kí (kiểm tra email, password, phone)
	 * 
	 * @param user: user được lấy từ form đăng kí có các thuộc tính là các input nhập
	 *             vào (chính là user rỗng ở method signup sau khi được set giá
	 *             trị bằng các nhập vào)
	 * @param result: dùng để kiểm tra lỗi và bắt buộc phải đứng ngay sau đối tượng
	 *               được kiểm tra validate
	 * @param model
	 * @param request: dùng để thêm vào session
	 * @return: - đăng kí thành công thì chuyển về trang chủ 
	 *          - đăng kí thất bại thì chuyển về trang đăng kí và kiển thị ra lỗi
	 */
	@RequestMapping(value = "/formSignUp", method = RequestMethod.POST)
	public String handleSignUp(@ModelAttribute("user") @Validated User user, BindingResult result, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "signup";
		} else {
			userService.insertUser(user); // đăng kí thành công => insert xuống database
			HttpSession session = request.getSession();
			session.setAttribute("userName", user.getName());
			return "redirect:/index";

		}
	}

	/**
	 * hàm xử lý tác vụ đăng nhập (kiểm tra email, password)
	 * 
	 * @param user: user được lấy từ form đăng đăng nhập có các thuộc tính là email
	 *        và pass được nhập vào ở trên form (chính là user rỗng ở login được set
	 *        giá trị)
	 * @param result: dùng để kiểm tra lỗi và bắt buộc phải đứng ngay sau đối tượng
	 *               được kiểm tra validate
	 * @param model
	 * @param request: dùng để thêm vào session
	 * @return: - đăng nhập thành công thì chuyển về trang chủ 
	 *          - đăng nhập thất bại thì chuyển về trang đăng nhập và kiển thị ra lỗi
	 */
	@RequestMapping(value = "/formLogin", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("user") @Validated User user, BindingResult result, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "login";
		} else {
			// tìm user dưới database theo user ở trang đăng nhập
			User userFind = userService.searchUserInDatabase(user);
			HttpSession session = request.getSession();
			session.setAttribute("userName", userFind.getName());
			return "redirect:/index";
		}
	}

}
