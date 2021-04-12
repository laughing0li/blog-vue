package com.banjo.blogvue.controller.admin;


import com.banjo.blogvue.pojo.User;
import com.banjo.blogvue.service.UserService;
import com.banjo.blogvue.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.HtmlUtils;
import javax.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        String name = HtmlUtils.htmlEscape(username);
        String pwd = MD5Util.code(password);
        User user = userService.checkUser(name, pwd);
        if (user != null) {
            user.setPassword("");
            session.setAttribute("user", user);
            return "admin/listBlogs";
        } else {
            attributes.addFlashAttribute("msg", "Incorrect password or username pls try again!");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session,
                         RedirectAttributes redirectAttributes) {
        session.removeAttribute("user");;
        redirectAttributes.addFlashAttribute("msg", "Logout Success!");
        return "admin/login";
    }
}
