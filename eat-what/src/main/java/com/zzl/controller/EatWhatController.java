package com.zzl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Description:
 * Created by 乍暖还寒 on 2020/8/11 23:32
 * Version 1.0
 */
@Controller
public class EatWhatController {

    private String[] menu = null;
    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @PostMapping("/menu")
    public String result(@RequestParam("name") String[] menu, Model model){
        System.out.println(menu.length);
        this.menu = menu;
        int random = new Random().nextInt(this.menu.length );
        model.addAttribute("menu",this.menu[random]);
        return "result";
    }
    @PostMapping("/result")
    public String resultPost(Model model){
        if (this.menu == null){
            return "index";
        }else {
            System.out.println("result"+ System.currentTimeMillis());
            int random = new Random().nextInt(this.menu.length );
            model.addAttribute("menu",this.menu[random]);
            return "result";
        }
    }
    @GetMapping("/result")
    public String resultGet(Model model){
        if (this.menu == null){
            return "index";
        }else {
            System.out.println("result"+ System.currentTimeMillis());
            int random = new Random().nextInt(this.menu.length );
            model.addAttribute("menu",this.menu[random]);
            return "result";
        }
    }
    @GetMapping("/404")
    public String error404(Model model){
        System.out.println("404");
        return "error/404";
    }
    @GetMapping("/500")
    public String error500(Model model){
        System.out.println("500");
        return "error/500";
    }


}
