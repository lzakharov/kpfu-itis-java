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
@WebServlet(name = "DeleteCommentServlet")
public class DeleteCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Integer.parseInt(request.getParameter("author_id")) == UserRepository.getUserIdByUsername(request.getSession().getAttribute("current_user").toString())) {
            Repository repository = new Repository();
            CommentRepository.deleteComment(Integer.parseInt(request.getParameter("comment_id")));
            response.sendRedirect("/article/show?id=" + request.getParameter("article_id"));
        }
    }
}
