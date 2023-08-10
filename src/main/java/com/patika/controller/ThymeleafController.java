package com.patika.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // controller yaratacaksak sınıfın başına bunu yazmamız gerek.
public class ThymeleafController {

    //url http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1") //oluşacak sayfanın urlsinin devamını belirtmesi için kullanıyoruz.
    //@ResponseBody
    public String getThymeleaf1(){
        return "thymeleaf1";
    }

    //url http://localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2") //oluşacak sayfanın urlsinin devamını belirtmesi için kullanıyoruz.
    //@ResponseBody
    public String getThymeleaf2Model(Model model){
        model.addAttribute("key_model","Ben modelden geldim.");
        model.addAttribute("key_model2","Ben modelden geldim 2");
        return "thymeleaf1";
    }
    //url http://localhost:8080/thymeleaf3
    @GetMapping("/thymeleaf3") //oluşacak sayfanın urlsinin devamını belirtmesi için kullanıyoruz.
    //@ResponseBody
    public String getThymeleaf3Model(Model model){
        model.addAttribute("key_model","Ben modelden geldim.");
        model.addAttribute("key_model2","Ben modelden geldim 2");
        return "thymeleaf_file/thymeleaf3";
    }

}
