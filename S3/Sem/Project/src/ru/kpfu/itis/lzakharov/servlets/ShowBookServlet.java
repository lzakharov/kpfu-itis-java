package ru.kpfu.itis.lzakharov.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import ru.kpfu.itis.lzakharov.ConfigSingleton;
import ru.kpfu.itis.lzakharov.respository.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by levzaharov on 12.10.15.
 */
@WebServlet(name = "ru.kpfu.itis.lzakharov.servlets.ShowBookServlet")
public class ShowBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        Configuration config = ConfigSingleton.getConfig(getServletContext());
        Template template = config.getTemplate("book_show.ftl");
        HashMap<String, Object> root = new HashMap<>();
        root.put("current_user", request.getSession().getAttribute("current_user"));
        root.put("book", BookRepository.getBookById(Integer.parseInt(request.getParameter("id"))));

        try {
            template.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
