package cn.edidada.controller;

import cn.edidada.model.User;
import cn.edidada.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public String login(@RequestBody User user) throws ServletException {
        String name = user.getUsername();
        String pass = user.getPassword();
        if (!"admin".equals(name)) {
            throw new ServletException("no such user");
        }
        if (!"1234".equals(pass)) {
            throw new ServletException("wrong password");
        }
        String token = JwtUtil.getToken(name);
        return token;
    }

    @GetMapping("/success")
    public String success() {
        return "login success";
    }
}
