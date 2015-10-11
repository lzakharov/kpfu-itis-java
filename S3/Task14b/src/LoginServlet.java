import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by levzaharov on 09.10.15.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private HashMap<String, String> users;
    private void getCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("username")) {
                request.getSession().setAttribute("current_user", cookie.getValue());
            }
        }
    }

    private void tryToAutoLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        getCookies(request);
        if (request.getSession().getAttribute("current_user") != null) {
            response.sendRedirect("/profile");
        }
    }

    @Override
    public void init() {
        users = new HashMap<>();
        users.put("lev", "123");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        tryToAutoLogin(request, response);

        String username = request.getParameter("username");
        if (request.getParameter("passwd").equals(users.get(username))) {
            request.getSession().setAttribute("current_user", username);
            if (request.getParameter("checkbox") != null) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(60 * 60 * 24);
                cookie.setPath("/");
                response.addCookie(cookie);
            }

            response.sendRedirect("/profile");
        } else {
            if (!users.containsKey(username)) {
                response.sendRedirect("/login?error_msg=Wrong%20username&username=" + username);
            }
            if (users.containsKey(username) && !users.get(username).equals(request.getParameter("passwd"))) {
                response.sendRedirect("/login?error_msg=Wrong%20password&username=" + username);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        tryToAutoLogin(request, response);

        Configuration config = ConfigSingleton.getConfig(getServletContext());
        Template template = config.getTemplate("login.ftl");
        HashMap<String, Object> root = new HashMap<>();
        root.put("error_msg", request.getParameter("error_msg"));
        root.put("username", request.getParameter("username"));

        try {
            template.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
