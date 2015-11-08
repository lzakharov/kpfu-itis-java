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
@WebServlet(name = "CreateReviewServlet")
public class CreateReviewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Repository repository = new Repository();
        ReviewRepository.addReview(Integer.parseInt(request.getParameter("book_id")),
                UserRepository.getUserIdByUsername(request.getSession().getAttribute("current_user").toString()),
                Integer.parseInt(request.getParameter("type")),
                request.getParameter("text"));

        response.sendRedirect("/book/show?id=" + request.getParameter("book_id"));
    }
}
