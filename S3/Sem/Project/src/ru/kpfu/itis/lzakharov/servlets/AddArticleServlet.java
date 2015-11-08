package ru.kpfu.itis.lzakharov.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import ru.kpfu.itis.lzakharov.ConfigSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lzakharov on 08.11.15.
 */
@WebServlet(name = "AddArticleServlet")
public class AddArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration config = ConfigSingleton.getConfig(getServletContext());
        Template template = config.getTemplate("article_add.ftl");
    }
}