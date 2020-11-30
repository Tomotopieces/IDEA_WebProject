package io.tomoto.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author Tomoto
 * <p>
 * 2020/11/27 9:34
 */
@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        if (ServletFileUpload.isMultipartContent(req)) {
            resp.setContentType("text/html; charset=utf-8");
            resp.setCharacterEncoding("utf-8");
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
            try {
                List<FileItem> fileItems = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : fileItems) {
                    if (fileItem.isFormField()) { // normal form item
                        System.out.println("Item: " + fileItem.getString("UTF-8"));
                    } else { // multipart item
                        System.out.println("form name: " + fileItem.getFieldName());
                        System.out.println("file name: " + fileItem.getName());
                        fileItem.write(new File("D:/upload/" + new Date().getTime() + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
