package ru.kpfu.itis.lzakharov.servlets;

import ru.kpfu.itis.lzakharov.respository.Repository;
import ru.kpfu.itis.lzakharov.respository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by lzakharov on 01.11.15.
 */
@WebServlet(name = "ChangeInfoServlet")
public class ChangeInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String current_user = request.getSession().getAttribute("current_user").toString();
        Repository repository = new Repository();
        UserRepository.changeUserInfo(UserRepository.getUserIdByUsername(current_user),
                request.getParameter("first_name"),
                request.getParameter("last_name"),
                request.getParameter("email"),
                request.getParameter("address")
        );
        response.sendRedirect("/profile");
    }
}
