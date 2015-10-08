import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by levzaharov on 08.10.15.
 */
@WebServlet(name = "MultServlet")
public class MultServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration config = ConfigSingleton.getConfig(getServletContext());
        Template template = config.getTemplate("/add.ftl");
        HashMap<String, Object> root = new HashMap<>();

        String requestArgs = request.getPathInfo();
        String[] args = requestArgs.substring(1).split("/");

        try {
            root.put("res", Integer.parseInt(args[0]) * Integer.parseInt(args[1]));
            template.process(root, response.getWriter());
        } catch (NumberFormatException e) {
            response.sendError(400, "Bad request");
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
