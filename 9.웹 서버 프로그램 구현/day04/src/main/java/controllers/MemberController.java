package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member/*") // xml에 정의하지않고 바로 간단하게 정의하는 방법이다.
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
        // 배열은 0부터 시작하니까 순서에서 -1을 해줘야 한다.
        return mode;
    }
    // 회원 가입 양식
    private void joinForm(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<h1>회원가입</h1>");

    }

    // 로그인 양식
    private void loginForm(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>로그인</h1>");
    }

    // 회원 가입
    private void joinProcess(HttpServletRequest req, HttpServletResponse resp) {

    }

    // 로그인 처리
    private void loginProcess(HttpServletRequest req, HttpServletResponse resp) {

    }
}