package io.tomoto.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Tomoto
 * <p>
 * 2020/11/25 9:28
 */
@WebServlet("/createCookie")
public class CreateCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // create a new cookie
        Cookie cookie = new Cookie("IzzelAliz", "Izzel");

        // The mechanism of maxAge works like
        // change/manipulate expiration date of cookie (based on SERVER_SIDE)
        // but browser checks cookie's expiration date, based on CLIENT_SIDE.
        // https://stackoverflow.com/a/37495774/12348320
        //
        // Don't trust Cookie setMaxAge
        // https://www.infoworld.com/article/2073096/don-t-trust-cookie-setmaxage.html
        cookie.setMaxAge(30 * 60 * 1000);

        // delete cookie
//        cookie.setMaxAge(0);
        // client save cookie
        resp.addCookie(cookie);
        // say something
        System.out.println("Cookie saved");
        // jump
//        req.getRequestDispatcher("/getCookie").forward(req, resp);
    }
}
