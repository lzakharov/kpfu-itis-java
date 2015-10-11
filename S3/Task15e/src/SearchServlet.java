import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import org.apache.velocity.servlet.VelocityServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by levzaharov on 11.10.15.
 */
@WebServlet(name = "SearchServlet")
public class SearchServlet extends VelocityServlet {
    public Template handleRequest( HttpServletRequest request,
                                   HttpServletResponse response,
                                   Context context ) throws IOException {

        Template template = null;

        try {
            switch (request.getPathInfo().substring(1)) {
                case "baidu":
                    context.put("form_action", "http://www.baidu.com/s");
                    context.put("input_name", "wd");
                    break;
                case "bing":
                    context.put("form_action", "http://www.bing.com/search");
                    context.put("input_name", "q");
                    break;
                case "yahoo":
                    context.put("form_action", "https://search.yahoo.com/search");
                    context.put("input_name", "p");
                    break;
                case "aol":
                    context.put("form_action", "http://search.aol.com/aol/search");
                    context.put("input_name", "q");
                    break;
                default:
                    response.sendError(400, "Bad request");
                    break;
            }
            template = Velocity.getTemplate("search.vm");
        } catch( Exception e ) {
            System.err.println("Exception caught: " + e.getMessage());
        }

        return template;
    }
}
