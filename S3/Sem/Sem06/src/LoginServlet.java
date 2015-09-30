import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by levzaharov on 30.09.15.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    HashMap<String, String> users = new HashMap<>();

    @Override
    public void init() {
        users.put("lev", "12345");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getCookies(request);
        HttpSession session = request.getSession();

        if (session.getAttribute("current_user") != null) {
            response.sendRedirect("/profile");
        } else {
            String username = request.getParameter("username");
            if (request.getParameter("passwd").equals(users.get(username))) {
                if (request.getParameter("checkbox") != null) {
                    session.setAttribute("current_user", username);
                    Cookie cookie = new Cookie("username", username);
                    cookie.setMaxAge(60 * 60 * 24);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                } else {
                    session.setAttribute("current_user", username);
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
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        getCookies(request);
        HttpSession session = request.getSession();

        if (session.getAttribute("current_user") != null) {
            response.sendRedirect("/profile");
        } else {
            PrintWriter writer = response.getWriter();
            if (request.getParameter("error_msg") != null) {
                writer.println("<p>" + request.getParameter("error_msg") + "</p>");
            }
            writer.println("<form name=\"login\" action=\"/login\" method=\"POST\">");
            if (request.getParameter("username") != null) {
                writer.println("<input name=\"username\" type=\"text\" value='" + request.getParameter("username")  + "'><br>");
            } else {
                writer.println("<input name=\"username\" type=\"text\"><br>");
            }
            writer.println("<input name=\"passwd\" type=\"password\"><br>" +
                           "<input name='checkbox' type='checkbox'>Запомнить?<br>" +
                           "<input name=\"submit\" type=\"submit\" value=\"Login\">" +
                           "</form>");
        }
    }

    private void getCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if ("username".equals(cookie.getName())) {
                    request.getSession().setAttribute("current_user", cookie.getValue());
                }
            }
        }
    }
}
