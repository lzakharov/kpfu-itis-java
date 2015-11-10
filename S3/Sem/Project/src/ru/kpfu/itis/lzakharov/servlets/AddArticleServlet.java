package ru.kpfu.itis.lzakharov.servlets;

import com.ibm.useful.http.FileData;
import com.ibm.useful.http.PostData;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import ru.kpfu.itis.lzakharov.ConfigSingleton;
import ru.kpfu.itis.lzakharov.respository.ArticleDataRepository;
import ru.kpfu.itis.lzakharov.respository.ArticleRepository;
import ru.kpfu.itis.lzakharov.respository.Repository;
import ru.kpfu.itis.lzakharov.respository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;

/**
 * Created by lzakharov on 08.11.15.
 */
@WebServlet(name = "AddArticleServlet")
public class AddArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Repository repository = new Repository();
        PostData multidata = new PostData(request);
        int article_id = ArticleRepository.addArticle(multidata.getParameter("title"),
                UserRepository.getUserIdByUsername(request.getSession().getAttribute("current_user").toString()),
                multidata.getParameter("description"));

        FileData image = multidata.getFileData("image");
        String path = null;
        if(image.getFileName() != null){
            File f = new File(image.getFileName());
            path = f.getAbsolutePath();
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(image.getByteData());
            fos.close();
        }

        ArticleDataRepository.addArticleData(article_id, multidata.getParameter("text"), path);

        response.sendRedirect("/article/show?id=" + article_id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        Configuration config = ConfigSingleton.getConfig(getServletContext());
        Template template = config.getTemplate("article_add.ftl");
        HashMap<String, Object> root = new HashMap<>();
        root.put("user_id", UserRepository.getUserIdByUsername(request.getSession().getAttribute("current_user").toString()));

        try {
            template.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
