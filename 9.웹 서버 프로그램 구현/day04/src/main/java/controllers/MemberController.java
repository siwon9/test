package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberController extends HttpServlet { //이걸 상속함으로써 서블릿 객체를 만들 수 있음

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) // 객체를 tomcat이 만들어주는거임
            throws ServletException, IOException {
        String mode =getMode(req);
        if(mode.equals("join")) {
            joinForm(req, resp);
        } else if (mode.equals("login")) {
            loginForm(req, resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String mode = getMode(req);
        if(mode.equals("join")) {
            joinProcess(req,resp);
        } else if (mode.equals("login")){
            loginProcess(req,resp);
        }
    }

    private String getMode(HttpServletRequest req) {
        String url = req.getRequestURI();
        String[] urls = url.split("/");
        String mode = urls.length > 0 ? urls[urls.length -1] : ""; // 3항연산자

        return mode;
    }

    private void joinForm(HttpServletRequest req, HttpServletResponse resp) {

    }
}
