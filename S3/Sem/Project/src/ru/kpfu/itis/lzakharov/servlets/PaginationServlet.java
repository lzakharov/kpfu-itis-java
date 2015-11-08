package ru.kpfu.itis.lzakharov.servlets;

import org.json.JSONObject;
import ru.kpfu.itis.lzakharov.respository.ArticleRepository;
import ru.kpfu.itis.lzakharov.respository.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lzakharov on 08.11.15.
 */
@WebServlet(name = "PaginationServlet")
public class PaginationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Repository repository = new Repository();
        int pageNum = Integer.parseInt(request.getParameter("page_num"));
        JSONObject object = ArticleRepository.getArticlesCut(pageNum);
        response.setContentType("text/json; charset=UTF-8");
        response.getWriter().print(object.toString());
    }
}
