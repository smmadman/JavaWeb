package com.junjie.web;

import com.junjie.pojo.User;
import com.junjie.service.UserService;
import com.junjie.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        System.out.println("username:  " + username);
        System.out.println("password:  " + password);
        System.out.println("email:  " + email);
        System.out.println("code:  " + code);

        //2.检查验证码是否正确 ==》这里先写死 要求验证码为abcde
        if("abcde".equalsIgnoreCase(code)){//验证码正确

            if(userService.existsUsername(username)){//已存在，不可用
                System.out.println("用户名[" + username + "]已存在！");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);//跳回注册页面
            }else{//用户名不存在，可用

                //调用Service保存到数据库
                userService.registerUser(new User(null, username, password, email));

                //跳转到regist_success.html
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }

        }else{
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);//跳回注册页面
        }
    }
}
