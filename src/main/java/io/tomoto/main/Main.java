package io.tomoto.main;

import com.google.gson.Gson;
import io.tomoto.entity.User;

/**
 * @author Tomoto
 * <p>
 * 2020/11/24 8:47
 */
public class Main {
    public static void main(String[] args) {
        User user = new User(1, "IzzelAliz", "HaiLuo", 19, "12345678901");

        Gson gson = new Gson();
        String str = gson.toJson(user);
        System.out.println(str);

        System.out.println(gson.fromJson(str, User.class));
    }
}
