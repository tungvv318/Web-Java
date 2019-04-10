package springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.Category;
import springmvc.model.Product;
import springmvc.service.ProductService;
import springmvc.validator.UserFormValidator;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String productPage(ModelMap model, @RequestParam Integer id) {
		// id on url, is id of book selected and is id of book in database
		
		List<Category> lstCategory = productService.getListCategory();
		model.addAttribute("lstCategory", lstCategory);
		
		int idProductSelected = id;
		Product productSelected = productService.getProductByID(idProductSelected);
		model.addAttribute("productSelected", productSelected);

		List<Product> lstProductSameCategory = productService.getListProductsByCategory(productSelected.getCategory());
		model.addAttribute("lstProductSameCategory", lstProductSameCategory);
		
		List<Product> lstProductsByTime = productService.getListProductsByTime();
		model.addAttribute("lstProductsByTime", lstProductsByTime);
		
		return "product";
	}
}
