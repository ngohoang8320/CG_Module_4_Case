package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
<<<<<<< HEAD
    @GetMapping("" )
    public ModelAndView index(Model model){
        List<String> typeList = productService.getProductType();
        List<List<Product>> productList = productService.getProductListByType();
        model.addAttribute("productListByType",productList);
        model.addAttribute("typeList", typeList);
=======

    @GetMapping("")
    public ModelAndView index(Model model) {
        List<String> typeList = productService.getProductType();
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",
                productList);
        model.addAttribute("typeList",
                typeList);
>>>>>>> f9cde9896b97c41b1d860eb5895c388408c47801
        return new ModelAndView("/landingPage");
    }

    @GetMapping("/home")
    public ModelAndView homePage(Model model) {
        List<String> typeList = productService.getProductType();
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",
                productList);
        model.addAttribute("typeList",
                typeList);

        return new ModelAndView("/home");
    }

    @GetMapping("/sort")
    public ModelAndView getProductsByType(@RequestParam("type") String type,
                                          Model model) {
        List<String> typeList = productService.getProductType();
        List<Product> productList = productService.findByType(type);
<<<<<<< HEAD
        model.addAttribute("productList",productList);
        model.addAttribute("typeList", typeList);
        return new ModelAndView("/home") ;
=======
        model.addAttribute("productList",
                productList);
        model.addAttribute("typeList",
                typeList);
        return new ModelAndView("/landingPage");
>>>>>>> f9cde9896b97c41b1d860eb5895c388408c47801
    }

    @PostMapping("/search")
    public ModelAndView getProductByName(@RequestParam("proName") String proName,
                                         Model model) {
        List<String> typeList = productService.getProductType();
        List<Product> productList = productService.findByName(proName);
<<<<<<< HEAD
        model.addAttribute("productList",productList);
        model.addAttribute("typeList", typeList);
        return new ModelAndView("/home") ;
    }
    @GetMapping("/product")
    public ModelAndView getProductDetail(@RequestParam("proId") String proId, Model model){
        Product product = productService.findById(Long.valueOf(proId));
        List<String> typeList = productService.getProductType();
        model.addAttribute("product", product);
        model.addAttribute("typeList", typeList);
        return new ModelAndView("/product");
=======
        model.addAttribute("productList",
                productList);
        model.addAttribute("typeList",
                typeList);
        return new ModelAndView("/landingPage");
>>>>>>> f9cde9896b97c41b1d860eb5895c388408c47801
    }
}
