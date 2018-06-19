package com.shopmanager.controller;

import com.shopmanager.entity.ProductList;
import com.shopmanager.model.Catagory;
import com.shopmanager.model.Manager;
import com.shopmanager.model.Product;
import com.shopmanager.model.Subcata;
import com.shopmanager.service.CatagoryService;
import com.shopmanager.service.ManagerService;
import com.shopmanager.service.ProductService;
import com.shopmanager.service.SubCataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private CatagoryService catagoryService;

    @Autowired
    private SubCataService subCataService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String login(HttpServletRequest request, Model model){
        if("POST".equals(request.getMethod())){
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Manager user = managerService.getByMananame(username);
            if(user == null){
                String error = "用户名或密码错误";
                model.addAttribute("error",error);
                return "shop/login";
            }
            if(password.length() ==0){
                String error = "密码不能为空";
                model.addAttribute("error",error);
                return "shop/login";
            }else if(password.equals(user.getManaPassword())){
                model.addAttribute("username",username);
                request.getSession().setAttribute("username",username);
                List<Catagory> catagories = catagoryService.getAll();
                List<String> catenames = new ArrayList<>();
                for(Catagory catagory : catagories){
                    List<Subcata> subcatas = subCataService.getByCataId(catagory.getCataId());
                    for (Subcata subcata : subcatas){
                        catenames.add(subcata.getSubId()+"-"+catagory.getCataName()+"-"+subcata.getSubName());
                    }
                }
                model.addAttribute("catename","请选择分类");
                model.addAttribute("categorys",catenames);
                return "shop/index";
            }else {
                String error = "用户名或密码错误";
                model.addAttribute("error",error);
                return "shop/login";
            }
        }else{
            if(request.getSession().getAttribute("username") == null){
                return "shop/login";
            }
            List<Catagory> catagories = catagoryService.getAll();
            List<String> catenames = new ArrayList<>();
            for(Catagory catagory : catagories){
                List<Subcata> subcatas = subCataService.getByCataId(catagory.getCataId());
                for (Subcata subcata : subcatas){
                    catenames.add(subcata.getSubId()+"-"+catagory.getCataName()+"-"+subcata.getSubName());
                }
            }
            model.addAttribute("catename","请选择分类");
            model.addAttribute("categorys",catenames);
            return "shop/index";
        }
    }

    @RequestMapping("/add")
    public String index(HttpServletRequest request, Model model, @RequestParam("file")MultipartFile file){
        if(request.getSession().getAttribute("username") == null){
            return "shop/login";
        }
        String pro_name = request.getParameter("pro_name");
        String pro_price = request.getParameter("pro_price");
        String pro_stack = request.getParameter("pro_stack");
        String pro_size = request.getParameter("pro_size");
        String pro_desc = request.getParameter("pro_desc");
        String sub_id = request.getParameter("catename").split("-")[0];
        Product product = new Product();
        product.setProName(pro_name);
        try {
            int price = Integer.parseInt(pro_price);
            int stack = Integer.parseInt(pro_stack);
            int sub = Integer.parseInt(sub_id);
            product.setProPrice(price);
            product.setProStack(stack);
            product.setSubId(sub);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            List<Catagory> catagories = catagoryService.getAll();
            List<String> catenames = new ArrayList<>();
            for(Catagory catagory : catagories){
                List<Subcata> subcatas = subCataService.getByCataId(catagory.getCataId());
                for (Subcata subcata : subcatas){
                    catenames.add(subcata.getSubId()+"-"+catagory.getCataName()+"-"+subcata.getSubName());
                }
            }
            model.addAttribute("catename","请选择分类");
            model.addAttribute("categorys",catenames);

            return "shop/index";
        }
        product.setProSize(pro_size);
        product.setProDesc(pro_desc);

        String filename = file.getOriginalFilename();
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path = "\\img\\" + filename;
        File tempFile = new File(pathRoot+path);
        if(!tempFile.getParentFile().exists()){
            tempFile.getParentFile().mkdir();
        }
        if(!tempFile.exists()){
            tempFile.mkdir();
        }
        try {
            file.transferTo(tempFile);
            product.setProImage(path);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        productService.add(product);

        return "redirect:/shop/list";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request,Model model){
        if(request.getSession().getAttribute("username") == null){
            return "shop/login";
        }
        List<Product> products = productService.getAll();
        List<Catagory> catagories = catagoryService.getAll();
        List<Subcata> subcatas = subCataService.getAll();
        List<ProductList> productLists = new ArrayList<>();
        for(Product product : products){
            ProductList productList = new ProductList();
            productList.setProname(product.getProName());
            for(Subcata subcata : subcatas){
                if(subcata.getSubId() == product.getSubId()){
                    for(Catagory catagory : catagories){
                        if(catagory.getCataId() == subcata.getCataId()){
                            productList.setCatagory(catagory.getCataName()+"-"+subcata.getSubName());
                            break;
                        }
                    }
                    break;
                }
            }
            productList.setPrice(product.getProPrice());
            productList.setSize(product.getProSize());
            productLists.add(productList);
        }
        model.addAttribute("products",productLists);
        return "shop/list";
    }
}
