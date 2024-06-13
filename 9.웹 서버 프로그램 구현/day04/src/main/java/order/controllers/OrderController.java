package order.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/order")
public class OrderController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

            // 서비스 처리...
            req.setAttribute("message", "처리완료"); // 서블릿 통해서만 유입되서 뷰가 나온다.

        // 출력 처리(View)...
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/order/order.jsp"); // 기준경로 webapp이다.
        rd.forward(req, resp);
    }
}


