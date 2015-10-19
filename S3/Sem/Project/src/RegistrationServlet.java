import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.SplittableRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lzakharov on 19.10.15.
 */
@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Repository repository = new Repository();
        if (isUsernameUsed(response, request.getParameter("username"))) {
            response.sendRedirect("/registration?error_msg=user%20exists");
        }
        else if (isEmailUsed(response, request.getParameter("email"))) {
            response.sendRedirect("/registration?error_msg=email%20exists");
        } else if (isPasswordConfirm(response, request.getParameter("password"), request.getParameter("password_confirm"))) {
            response.sendRedirect("/registration?error_msg=password%20mismatch");
        } else if (passwordValidation(response, request.getParameter("password"))) {
            response.sendRedirect("/registration?error_msg=password%20format");
        } else {
            UsersRepository.addUser(new User(request.getParameter("username"), request.getParameter("first_name"),
                    request.getParameter("last_name"), request.getParameter("password"), request.getParameter("email"),
                    Date.valueOf(request.getParameter("birthdate")), request.getParameter("address")));

            response.sendRedirect("/login?message=successful%20registration");
        }
    }

    private boolean passwordValidation(HttpServletResponse response, String password) throws IOException {
//        Pattern pattern = Pattern.compile("((?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d).{6,})");
//        Matcher matcher = pattern.matcher(password);
//        return !matcher.matches();
        return false;
    }

    private boolean isPasswordConfirm(HttpServletResponse response, String password, String password_confirm) throws IOException {
        return !password.equals(password_confirm);

    }

    private boolean isEmailUsed(HttpServletResponse response, String email) throws IOException {
        return UsersRepository.getUserByEmail(email) != null;
    }

    private boolean isUsernameUsed(HttpServletResponse response, String username) throws IOException {
        return UsersRepository.getUserByUsername(username) != null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Configuration config = ConfigSingleton.getConfig(getServletContext());
        Template template = config.getTemplate("registration.ftl");
        HashMap<String, Object> root = new HashMap<>();
        root.put("error_msg", request.getParameter("error_msg"));
        root.put("username", request.getParameter("username"));
        root.put("first_name", request.getParameter("first_name"));
        root.put("last_name", request.getParameter("last_name"));
        root.put("birthdate", request.getParameter("birthdate"));
        root.put("address", request.getParameter("address"));

        try {
            template.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }


    }
}
