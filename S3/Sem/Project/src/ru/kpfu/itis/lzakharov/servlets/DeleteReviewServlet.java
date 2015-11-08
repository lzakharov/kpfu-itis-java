package ru.kpfu.itis.lzakharov.servlets;

import ru.kpfu.itis.lzakharov.respository.Repository;
import ru.kpfu.itis.lzakharov.respository.ReviewRepository;
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
@WebServlet(name = "DeleteReviewServlet")
public class DeleteReviewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Integer.parseInt(request.getParameter("author_id")) == UserRepository.getUserIdByUsername(request.getSession().getAttribute("current_user").toString())) {
            Repository repository = new Repository();
            ReviewRepository.deleteReview(Integer.parseInt(request.getParameter("review_id")));
            response.sendRedirect("/book/show?id=" + request.getParameter("book_id"));
        }
    }
}
