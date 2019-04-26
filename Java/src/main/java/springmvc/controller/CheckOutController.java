package springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.Cart;
import springmvc.model.Category;
import springmvc.model.Product;
import springmvc.service.ProductService;

@Controller
public class CheckOutController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkOut(ModelMap model) {
		// lấy danh sách thể loại dưới database
		List<Category> lstCategory = productService.getListCategory();
		model.addAttribute("lstCategory", lstCategory);
		return "checkout";
	}
	@RequestMapping(value = "/buynow", method = RequestMethod.GET)
	public String buyNow(ModelMap model, HttpSession session, @RequestParam(name = "id") Integer productId) {
		// lấy danh sách thể loại dưới database
		List<Category> lstCategory = productService.getListCategory();
		model.addAttribute("lstCategory", lstCategory);
		
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = productService.getProductByID(productId);
        if (product != null) {
            if (cartItems.containsKey(productId)) {
                Cart item = cartItems.get(productId);
                item.setProduct(product);
                item.setQuantityBuy(item.getQuantityBuy() + 1);
                cartItems.put(productId, item);
            } else {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantityBuy(1);
                cartItems.put(productId, item);
            }
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("sizeCart", countProduct(cartItems));
        session.setAttribute("myCartNum", cartItems.size());
		return "checkout";
	}
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String removeProduct(ModelMap model, HttpSession session, @RequestParam(name = "id") Integer productId) {
		// lấy danh sách thể loại dưới database
		List<Category> lstCategory = productService.getListCategory();
		model.addAttribute("lstCategory", lstCategory);
		
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        if (cartItems.containsKey(productId)) {
            cartItems.remove(productId);
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("sizeCart", countProduct(cartItems));
        session.setAttribute("myCartNum", cartItems.size());
		return "checkout";
	}
	private double totalPrice(HashMap<Integer, Cart> cartItems) {
        int price = 0;
        for (Map.Entry<Integer, Cart> list : cartItems.entrySet()) {
        	price += list.getValue().getProduct().getPriceUnitProduct() * list.getValue().getQuantityBuy();
        }
        return price;
    }
    private int countProduct(HashMap<Integer, Cart> cartItems) {
        int countProduct = 0;
        for (Map.Entry<Integer, Cart> list : cartItems.entrySet()) {
        	countProduct += list.getValue().getQuantityBuy();
        }
        return countProduct;
    }
}
