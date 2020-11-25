package io.tomoto.servlet;

import io.tomoto.util.CookieUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * @author Tomoto
 * <p>
 * 2020/11/25 14:32
 */
@WebServlet("/goods")
public class GoodsServlet extends HttpServlet {
    public static final String COOKIE_NAME = "goods";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String card = req.getParameter("name");
        if (card != null) {
            Cookie[] cookies = req.getCookies();
            Cookie cookie = CookieUtil.findCookie(COOKIE_NAME, cookies);
            if (cookie == null) {
                cookie = new Cookie(COOKIE_NAME, "");
            }
            String[] goodNames = cookie.getValue().split("&");
            LinkedHashSet<String> goodsSet = new LinkedHashSet<>(Arrays.asList(goodNames));
            goodsSet.add(card);
            cookie.setValue(goodsSet.toString().substring(1, goodsSet.toString().length() - 1).replaceAll(", ", "&"));
            resp.addCookie(cookie);
        }
        resp.sendRedirect("/IDEA_WebProject/market.jsp");
    }
}
