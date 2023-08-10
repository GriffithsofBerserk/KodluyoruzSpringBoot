package com.patika.controller;

import com.patika.bean.BeanConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
public class BeanController {
    @Autowired
    BeanConfig beanConfig;

    //http://localhost:8080/bean/beanDto
@GetMapping("/bean/beanDto") // url
@ResponseBody // html olmadan direkt ekranda göster
    public String getBeanDto(){
        return beanConfig.beanDto()+".";
    }
/////////////////////////////////////////////////////////////////////

    //@Autowired
    //Logger LOG;

    /*public BeanController() {
        LOG.info("log info çağrıldı!");
    }*/

   // @PostConstruct //Normal noargsconstructor ın içinde çağrıldığında null döner ama bu yapı kullanıldıgında injection gerçekleşmiş oluyor ve null dönmüyor
    //public void init(){
      //  LOG.info("log info çağrıldı!");
    }

    /*public static void main(String[] args) {
        BeanController beanController = new BeanController();
        System.out.println(beanController);
    }*/

