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
@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration config = ConfigSingleton.getConfig(getServletContext());
        Template template = config.getTemplate("/search.ftl");
        HashMap<String, Object> root = new HashMap<>();

        switch (request.getPathInfo().substring(1)) {
            case "baidu":
                root.put("form_action", "http://www.baidu.com/s");
                root.put("input_name", "wd");
                try {
                    template.process(root, response.getWriter());
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
                break;
            case "bing":
                root.put("form_action", "http://www.bing.com/search");
                root.put("input_name", "q");
                try {
                    template.process(root, response.getWriter());
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
                break;
            case "yahoo":
                root.put("form_action", "https://search.yahoo.com/search");
                root.put("input_name", "p");
                try {
                    template.process(root, response.getWriter());
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
                break;
            case "aol":
                root.put("form_action", "http://search.aol.com/aol/search");
                root.put("input_name", "q");
                try {
                    template.process(root, response.getWriter());
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
                break;
            default:
                response.sendError(400, "Bad request");
                break;
        }
    }
}
