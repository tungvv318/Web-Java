package springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.Category;
import springmvc.model.Product;
import springmvc.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	/**
	 * hàm dùng để chuyển hướng sang trang sản phẩm
	 * @param model
	 * @param id
	 * @return: hiển thị file product.jsp
	 */
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String productPage(ModelMap model, @RequestParam Integer id) {
		// id on url, is id of book selected and is id of book in database
		
		
		// // lấy danh sách thể loại dưới database
		List<Category> lstCategory = productService.getListCategory();
		model.addAttribute("lstCategory", lstCategory);
		
		// lấy product theo id để hiển thị sang page product
		int idProductSelected = id;
		Product productSelected = productService.getProductByID(idProductSelected);
		model.addAttribute("productSelected", productSelected);
		
		// lấy danh sách product có cùng thể loại
		List<Product> lstProductSameCategory = productService.getListProductsByCategory(productSelected.getCategory());
		model.addAttribute("lstProductSameCategory", lstProductSameCategory);
		
		// lấy danh sách product theo thời gian từ mới nhất đến cũ nhất
		List<Product> lstProductsByTime = productService.getListProductsByTime();
		model.addAttribute("lstProductsByTime", lstProductsByTime);
		
		return "product";
	}
}
