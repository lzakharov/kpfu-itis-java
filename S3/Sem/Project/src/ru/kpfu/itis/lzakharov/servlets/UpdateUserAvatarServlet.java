package ru.kpfu.itis.lzakharov.servlets;

import com.ibm.useful.http.FileData;
import com.ibm.useful.http.PostData;
import ru.kpfu.itis.lzakharov.respository.Repository;
import ru.kpfu.itis.lzakharov.respository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lzakharov on 17.11.15.
 */

@WebServlet(name = "UpdateUserAvatarServlet")
public class UpdateUserAvatarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Repository repository = new Repository();
        PostData multidata = new PostData(request);

        FileData image = multidata.getFileData("avatar");
        String path = null;
        if(image.getFileName() != null){
            File f = new File(image.getFileName());
            path = f.getAbsolutePath();
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(image.getByteData());
            fos.close();
        }
        String current_user = request.getSession().getAttribute("current_user").toString();
        UserRepository.updateAvatar(UserRepository.getUserIdByUsername(current_user), path);

        response.sendRedirect("/profile");
    }
}
