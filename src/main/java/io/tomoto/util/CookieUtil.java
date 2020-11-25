package io.tomoto.util;

import javax.servlet.http.Cookie;

/**
 * Util class for Cookie.
 *
 * @author Tomoto
 * <p>
 * 2020/11/25 9:43
 */
public class CookieUtil {

    /**
     * Find the cookie with specified name in cookies.
     *
     * @param name    a cookie name
     * @param cookies the cookie
     * @return the cookie with the name or null if not exists
     */
    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
//        return Arrays.stream(cookies).filter(cookie -> cookie.getName().equals(name)).findFirst().orElse(null);
        return null;
    }
}
