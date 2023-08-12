package com.patika.controller;

import com.patika.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller // controller yaratacaksak sınıfın başına bunu yazmamız gerek.
public class ThymeleafController {
    //option root {}
    //url http://localhost:8080
    @GetMapping({"/","index"})// uzantının devamına index de yazsak boş da bıraksak aynı sayfaya cıkması gösterildi.
    public String index(){
        return "index";
    }


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
    //url http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4") //oluşacak sayfanın urlsinin devamını belirtmesi için kullanıyoruz.
    //@ResponseBody
    public String getThymeleaf4Model(Model model){
        model.addAttribute("key_model1","Ben modelden geldim-4");
        return "thymeleaf4";
    }
    // Model Object göndermek
    //url http://localhost:8080/thymeleaf5
    @GetMapping("/thymeleaf5") //oluşacak sayfanın urlsinin devamını belirtmesi için kullanıyoruz.
    //@ResponseBody
    public String getThymeleaf5ModelObject(Model model){
        model.addAttribute("key_model1","text");
        ProductDto productDto =
                ProductDto
                        .builder()
                            .productId(0L)
                            .productName("Ürün adı")
                            .productPrice(2500)
                        .build();
        model.addAttribute("key_model2",productDto);
        return "thymeleaf5";
    }
    // Model Object List göndermek // liste gibi alt alta çalışması gerek ama çalışmadı.
    //url http://localhost:8080/thymeleaf6
    @GetMapping("/thymeleaf6")
    public String getThymeleaf6ModelObjectList(Model model){
        model.addAttribute("key_model1","text");
        List<ProductDto> listem=new ArrayList<>();
        listem.add(ProductDto.builder().productId(1L).productName("Ürün adı1").productPrice(1500).build());
        listem.add(ProductDto.builder().productId(2L).productName("Ürün adı2").productPrice(2500).build());
        listem.add(ProductDto.builder().productId(3L).productName("Ürün adı3").productPrice(3500).build());
        listem.add(ProductDto.builder().productId(4L).productName("Ürün adı4").productPrice(4500).build());
        model.addAttribute("product_liste", listem);
        return "thymeleaf6";
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    // Model Object göndermek
    //url http://localhost:8080/thymeleaf7/4 // yazdıgımız son uzantıyı yazıyor mesela bunda id4 çıktısı veriyor.
    //...uzantıyı değiştirip 63 yazsak bu sefer de id63 verecektir.
    //@GetMapping("/thymeleaf7/{id}") //oluşacak sayfanın urlsinin devamını belirtmesi için kullanıyoruz.
    @GetMapping({"/thymeleaf7/","/thymeleaf7/{id}"})// Aşağıdaki kodlarla beraber böylece bir şey yazılmadığında da
    //....çıktı verebiliyor.
    //@ResponseBody
    public String getThymeleaf7ModelObject(Model model, @PathVariable(name = "id",required = false) Long id){
        if (id!=null) {
            model.addAttribute("key_model1", "id" + id);
        }else {
            model.addAttribute("key_model1", "id bulunamadı");
        }
        return "thymeleaf7";
    }

}
