package io.tomoto.servlet;

import io.tomoto.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Tomoto
 * <p>
 * 2020/11/25 11:08
 */
@WebServlet("/lastVisit")
public class LastVisitServlet extends HttpServlet {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
    private static final String COOKIE_NAME = "lastTime";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        Cookie[] cookies = req.getCookies();
        Cookie cookie = CookieUtil.findCookie(COOKIE_NAME, cookies);
        if (cookie == null) { // first time
            resp.getWriter().print("您第一次访问本站");
            cookie = new Cookie(COOKIE_NAME, FORMAT.format(new Date()));
        } else {
            resp.getWriter().print("您上次的访问时间是: " + cookie.getValue());
            cookie.setValue(FORMAT.format(new Date()));
        }
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);
    }
}
