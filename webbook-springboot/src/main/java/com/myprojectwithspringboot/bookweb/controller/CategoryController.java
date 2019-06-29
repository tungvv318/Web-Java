package com.myprojectwithspringboot.bookweb.controller;

import java.util.List;

import com.myprojectwithspringboot.bookweb.model.Category;
import com.myprojectwithspringboot.bookweb.model.Product;
import com.myprojectwithspringboot.bookweb.service.CategoryService;
import com.myprojectwithspringboot.bookweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CategoryController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * hàm dùng để hiển thị trang thể loại sản phẩm
     * @param model
     * @param idCategory là id của thể sách
     * @return
     */
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String productPage(ModelMap model,
                              @RequestParam(required = false) Integer idCategory,
                              @RequestParam(name = "page", required = false, defaultValue = "0") Integer page) {
        model.addAttribute("idCategory", idCategory);

        // lấy các sản phẩm có cùng thể loại
        if (idCategory != null) {
            Category categoryById = categoryService.getCategoryByID(idCategory);
            List<Product> lstProductByCategory = categoryById.getListProduct();
            model.addAttribute("nameCategory", categoryById.getName());
            int size = 6;
            Pageable pageable = PageRequest.of(page, size);
            model.addAttribute("lstProductByCategory", productService.findProducts(categoryById, pageable));
            model.addAttribute("amoutPage", amountPage(size, lstProductByCategory.size()));
            model.addAttribute("idCategory", idCategory);
        }

        // lấy tên thể loại dưới database
        List<Category> lstCategory = categoryService.getListCategory();
        model.addAttribute("lstCategory", lstCategory);

        // lấy danh sách product theo thời gian từ mới nhất đến cũ nhất
        List<Product> lstProductsByTime = productService.getListProductsByTime();
        model.addAttribute("lstProductsByTime", lstProductsByTime);

        // lấy danh sách sản phẩm theo giá tăng dần
        List<Product> lstProductByPrice = productService.getListProductByPrice();
        model.addAttribute("lstProductByPrice", lstProductByPrice);
        return "category";
    }

    public int amountPage(int sizeOfPage, int amountProductSameCategory){
        int amountPage = 0;
        if(amountProductSameCategory % sizeOfPage == 0){
            amountPage = amountProductSameCategory/sizeOfPage;
        }
        else{
            amountPage = amountProductSameCategory/sizeOfPage + 1;
        }
        return amountPage;
    }
}

