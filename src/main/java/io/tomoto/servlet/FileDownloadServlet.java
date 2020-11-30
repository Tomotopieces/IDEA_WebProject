package io.tomoto.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Tomoto
 * <p>
 * 2020/11/27 10:43
 */
@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding("utf-8");

        String fileName = "momo.png";

        resp.setContentType("image/png");

        resp.setHeader("Content-Disposition", "attachment; fileName=" + fileName);
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("D:/download/momo.png"));
             ServletOutputStream out = resp.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
                out.flush();
            }
        }
    }
}
