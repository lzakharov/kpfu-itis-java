package ru.kpfu.itis.lzakharov.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import ru.kpfu.itis.lzakharov.ConfigSingleton;
import ru.kpfu.itis.lzakharov.models.User;
import ru.kpfu.itis.lzakharov.respository.Repository;
import ru.kpfu.itis.lzakharov.respository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * Created by lzakharov on 16.10.15.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getCookies(request);
        HttpSession session = request.getSession();

        if (session.getAttribute("current_user") != null) {
            response.sendRedirect("/profile");
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordHash = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            passwordHash = new String(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Repository repository = new Repository();
        User user = UserRepository.getUserByUsername(username);

        if (user == null) {
            response.sendRedirect("/login?error_msg=Wrong%20username&username=" + username);
        } else if (!user.isCorrectPassword(passwordHash)) {
            response.sendRedirect("/login?error_msg=Wrong%20password&username=" + username);
        } else {
            if (request.getParameter("checkbox") != null) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(60 * 60 * 24);
                cookie.setPath("/");
                response.addCookie(cookie);
            }

            session.setAttribute("current_user", username);
            response.sendRedirect("/profile");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        getCookies(request);
        HttpSession session = request.getSession();

        if (session.getAttribute("current_user") != null) {
            response.sendRedirect("/profile");
        }

        Configuration config = ConfigSingleton.getConfig(getServletContext());
        Template template = config.getTemplate("/login.ftl");

        HashMap<String, Object> root = new HashMap<>();
        root.put("error_msg", request.getParameter("error_msg"));
        root.put("username", request.getParameter("username"));
        root.put("email", request.getParameter("email"));
        root.put("first_name", request.getParameter("first_name"));
        root.put("last_name", request.getParameter("last_name"));
        root.put("message", request.getParameter("message"));

        try {
            template.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    private void getCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("username")) {
                request.getSession().setAttribute("current_user", cookie.getValue());
            }
        }
    }
}
