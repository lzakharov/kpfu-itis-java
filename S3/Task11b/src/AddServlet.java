import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by levzaharov on 29.09.15.
 */
@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String requestArgs = request.getPathInfo();
        String[] args = requestArgs.substring(1).split("/");

        try {
            response.getWriter().write("<p>" + (Integer.parseInt(args[0]) + Integer.parseInt(args[1])) + "</p>");
        } catch (NumberFormatException e) {
            response.sendError(400, "Bad request");
        }

    }
}
