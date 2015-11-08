package ru.kpfu.itis.lzakharov.servlets;

import ru.kpfu.itis.lzakharov.respository.CommentRepository;
import ru.kpfu.itis.lzakharov.respository.Repository;
import ru.kpfu.itis.lzakharov.respository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lzakharov on 04.11.15.
 */
@WebServlet(name = "CreateCommentServlet")
public class CreateCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Repository repository = new Repository();
        CommentRepository.addComment(Integer.parseInt(request.getParameter("article_id")),
                UserRepository.getUserIdByUsername(request.getSession().getAttribute("current_user").toString()),
                request.getParameter("text"));

        response.sendRedirect("/article/show?id=" + request.getParameter("article_id"));
    }
}
