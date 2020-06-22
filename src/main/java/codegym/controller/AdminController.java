package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String admin(){
        return "admin/dashboard";
    }
    @GetMapping("/tables")
    public String tables(){
        return "admin/tables";
    }
    @GetMapping("/user")
    public String user(){
        return "admin/user";
    }
}
