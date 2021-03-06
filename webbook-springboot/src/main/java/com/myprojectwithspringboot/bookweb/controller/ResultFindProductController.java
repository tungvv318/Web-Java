package com.myprojectwithspringboot.bookweb.controller;

import java.util.List;

import com.myprojectwithspringboot.bookweb.model.Category;
import com.myprojectwithspringboot.bookweb.model.Product;
import com.myprojectwithspringboot.bookweb.repository.ProductRepository;
import com.myprojectwithspringboot.bookweb.service.CategoryService;
import com.myprojectwithspringboot.bookweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ResultFindProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    /**
     * hàm dùng để hiển thị trang kết quả tìm kiếm
     * @param model
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchProductByText(ModelMap model, @RequestParam String keyword) {
        // // lấy tên loại dưới database
        List<Category> lstCategory = categoryService.getListCategory();
        model.addAttribute("lstCategory", lstCategory);

        model.addAttribute("keyword", keyword);
        List<Product> lstProductSearch = productService.getListProductByText(keyword);
        model.addAttribute("lstProductSearch", lstProductSearch);
        return "product-find";
    }
}
