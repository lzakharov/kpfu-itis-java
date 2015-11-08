package ru.kpfu.itis.lzakharov.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import ru.kpfu.itis.lzakharov.ConfigSingleton;
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
 * Created by levzaharov on 13.10.15.
 */
@WebServlet(name = "ru.kpfu.itis.lzakharov.servlets.ShowArticleServlet")
public class ShowArticleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        Configuration config = ConfigSingleton.getConfig(getServletContext());
        Repository repository = new Repository();
        Template template = config.getTemplate("article_show.ftl");
        HashMap<String, Object> root = new HashMap<>();
        root.put("current_user", request.getSession().getAttribute("current_user"));
        if (request.getSession().getAttribute("current_user") != null) {
            root.put("user_id", UserRepository.getUserIdByUsername(request.getSession().getAttribute("current_user").toString()));
        }
        root.put("article", ArticleRepository.getArticleById(Integer.parseInt(request.getParameter("id"))));
        root.put("article_data", ArticleDataRepository.getArticleDataById(Integer.parseInt(request.getParameter("id"))));
        LinkedList<Comment> comments = CommentRepository.getCommentsByArticleId(Integer.parseInt(request.getParameter("id")));
        root.put("comments", comments);

        try {
            template.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
