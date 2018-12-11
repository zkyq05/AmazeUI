package com.xh.springBoot.web;

import com.xh.springBoot.domain.AdminRepository;
import com.xh.springBoot.modle.qc_admin_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class HomeController {
    @Autowired
    AdminRepository adminRepository;

    @RequestMapping("/")
    public String index() {
        return "home/login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET,produces = {"text/html;charset=utf-8"})
    public String login(String username,String password,HttpServletResponse response) throws IOException {
        qc_admin_user user=adminRepository.findByUsername(username);

        if (user!=null&&user.getPassword().equals(password)){
            return "redirect:/home/index";
        }else {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script type=\"text/javascript\" charset=\"utf-8\">");
            if (user==null){
                out.println("alert('用户名错误！');");
            }else {
                out.println("alert('密码错误！');");
            }

            out.println("</script>");
            return "home/login";
        }
    }
    @RequestMapping("home/table_basic")
    public String tables() {
        return "home/table_basic";
    }
    @RequestMapping("index")
    public String homeI() {
        return "redirect:/home/index";
    }
    @RequestMapping("home/index")
    public String home() {
        return "home/index";
    }
    @RequestMapping("home/chart_line")
    public String chart() {
        return "home/chart_line";
    }
    @RequestMapping("home/table_complete")
    public String form() {
        return "home/table_complete";
    }
    @RequestMapping("home/chart_columnar")
    public String calendar() {
        return "home/chart_columnar";
    }
    @RequestMapping("home/chart_pie")
    public String table_list() {
        return "home/chart_pie";
    }
    @RequestMapping("home/form_basic")
    public String table_list_img() {
        return "home/form_basic";
    }
    @RequestMapping("home/form_validate")
    public String sign_up() {
        return "home/form_validate";
    }
    @RequestMapping("home/login")
    public String login() {
        return "home/login";
    }
    @RequestMapping("home/404")
    public String page404() {
        return "home/404";
    }

    @RequestMapping("main")
    public String main() {
        return "main/main";
    }
    @RequestMapping("main/head")
    public String head() {
        return "main/head";
    }
    @RequestMapping("main/menu")
    public String menu() {
        return "main/menu";
    }
    @RequestMapping("main/index")
    public String main_index() {
        return "main/index";
    }
    @RequestMapping("main/form")
    public String main_form() {
        return "main/form";
    }
}
