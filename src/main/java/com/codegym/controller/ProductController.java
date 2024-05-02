package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.CustomerService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("")
    public ModelAndView index(Model model){
        List<String> typeList = productService.getProductType();
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        model.addAttribute("typeList", typeList);
        return new ModelAndView("/landingPage");
    }
    @GetMapping("/home")
    public ModelAndView homePage( Model model){
        List<String> typeList = productService.getProductType();
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        model.addAttribute("typeList", typeList);

        return new ModelAndView("/landingPage");
    }
    @GetMapping("/sort")
    public ModelAndView getProductsByType(@RequestParam("type") String type, Model model) {
        List<String> typeList = productService.getProductType();
        List<Product> productList = productService.findByType(type);
        model.addAttribute("productList",productList);
        model.addAttribute("typeList", typeList);
        return new ModelAndView("/landingPage") ;
    }
    @PostMapping("/search")
    public ModelAndView getProductByName(@RequestParam("proName") String proName, Model model){
        List<String> typeList = productService.getProductType();
        List<Product> productList = productService.findByName(proName);
        model.addAttribute("productList",productList);
        model.addAttribute("typeList", typeList);
        return new ModelAndView("/landingPage") ;
    }
}
