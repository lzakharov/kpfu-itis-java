package ru.kpfu.itis.lzakharov.servlets;

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
        int article_id = ArticleRepository.addArticle(request.getParameter("title"),
                Integer.parseInt(request.getParameter("user_id")),
                request.getParameter("description"));


        PrintWriter out = response.getWriter ();

        String message = "Файл загружен успешно!";
        String err = "Ошибка при чтении файла - файл неопределен";
        String contentType = request.getContentType ();
        DataInputStream dis = new DataInputStream(request.getInputStream());

        int length = request.getContentLength();
        byte array[] = new byte[length];
        int dataRead = 0, totalData = 0;

        while (totalData < length){
            dataRead = dis.read(array, totalData, length);
            totalData += dataRead;
        }

        String data = new String(array);
        int lastIndex = contentType.lastIndexOf("=");
        String boundary = contentType.substring (lastIndex + 1, contentType.length());

        int position = data.indexOf("filename=\"");
        int pz_s = position + 10;
        position = data.indexOf("\n", position) + 1;
        int pz_e = position - 4;

        String FileName = "";

        if ((pz_s > 0) && (pz_s < pz_e))
        {
            FileName = "moved";
            char[] c = new char[pz_e - pz_s + 1];
            for (int i = pz_s; i <= pz_e; i++)
                c[i - pz_s] = data.charAt(i);
            FileName = String.valueOf(c, 0, c.length);
            pz_s = FileName.indexOf('\\');
            while (pz_s > 0)
            {
                FileName = FileName.substring (pz_s + 1, FileName.length());
                pz_s = FileName.indexOf('\\');
            }
        }

        if (FileName.length() > 0)
        {
            position = data.indexOf("\n", position) + 1;
            position = data.indexOf("\n", position) + 1;
            String fileData = data.substring(position, data.indexOf(boundary, position) - 4);
            if (fileData.length() > 0)
            {
                FileOutputStream fos = new FileOutputStream(FileName);
                fos.write (array, position, fileData.length());
                fos.close();
            }else
                message = err;
        }else
            message = err;
        dis.close ();

        ArticleDataRepository.addArticleData(article_id, request.getParameter("text"), new File(FileName));

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
