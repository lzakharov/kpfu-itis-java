package ru.kpfu.itis.lzakharov.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.json.JSONObject;
import ru.kpfu.itis.lzakharov.ConfigSingleton;
import ru.kpfu.itis.lzakharov.models.Book;
import ru.kpfu.itis.lzakharov.models.Comment;
import ru.kpfu.itis.lzakharov.respository.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by lzakharov on 07.11.15.
 */
@WebServlet(name = "MainPageServlet")
public class MainPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration config = ConfigSingleton.getConfig(getServletContext());
        Repository repository = new Repository();
        Template template = config.getTemplate("index.ftl");
        HashMap<String, Object> root = new HashMap<>();
        root.put("current_user", request.getSession().getAttribute("current_user"));
        root.put("last_articles", ArticleRepository.getLastFiveArticles());
        root.put("last_books", BookRepository.getTopFiveBooks());
        root.put("max_page", ArticleRepository.getCount() / 5 + ((ArticleRepository.getCount() % 5 != 0) ? 1 : 0));

        try {
            response.setContentType("text/html; charset=UTF-8");
            template.process(root, response.getWriter());

        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
