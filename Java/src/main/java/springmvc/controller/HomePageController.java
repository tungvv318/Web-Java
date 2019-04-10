package springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springmvc.model.Category;
import springmvc.model.Product;
import springmvc.service.ProductService;
import springmvc.validator.UserFormValidator;

@Controller
public class HomePageController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String homePage(ModelMap model, HttpServletRequest request) {
		List<Category> lstCategory = productService.getListCategory();
		model.addAttribute("lstCategory", lstCategory);
		List<Product> lstProductsByTime = productService.getListProductsByTime();
		model.addAttribute("lstProductsByTime", lstProductsByTime);
		return "index";
	}
}
