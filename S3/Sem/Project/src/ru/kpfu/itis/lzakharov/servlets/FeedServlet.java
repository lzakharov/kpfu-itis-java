package ru.kpfu.itis.lzakharov.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import ru.kpfu.itis.lzakharov.ConfigSingleton;
import ru.kpfu.itis.lzakharov.models.Article;
import ru.kpfu.itis.lzakharov.respository.ArticleRepository;
import ru.kpfu.itis.lzakharov.respository.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by lzakharov on 20.10.15.
 */
@WebServlet(name = "ru.kpfu.itis.lzakharov.servlets.FeedServlet")
public class FeedServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Configuration config = ConfigSingleton.getConfig(getServletContext());
        Repository repository = new Repository();
        Template template = config.getTemplate("feed.ftl");

        HashMap<String, Object> root = new HashMap<>();
        root.put("current_user", request.getSession().getAttribute("current_user"));
        LinkedList<Article> articles = ArticleRepository.getArticles();
        root.put("articles", articles);

        try {
            template.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
