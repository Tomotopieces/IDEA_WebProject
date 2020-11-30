package io.tomoto.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author Tomoto
 * <p>
 * 2020/11/26 10:14
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String code = req.getParameter("code");

        String token = req.getSession().getAttribute(KAPTCHA_SESSION_KEY).toString();
        if (token != null && token.equals(code)) {
            req.getSession().setAttribute("username", username);
            resp.sendRedirect("/IDEA_WebProject/welcome.jsp");
        } else {
            resp.sendRedirect("/IDEA_WebProject");
        }
    }
}
