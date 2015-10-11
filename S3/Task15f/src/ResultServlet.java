import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import org.apache.velocity.servlet.VelocityServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by levzaharov on 09.10.15.
 */
@WebServlet(name = "ResultServlet")
public class ResultServlet extends VelocityServlet {
    public Template handleRequest(HttpServletRequest request,
                                  HttpServletResponse response,
                                  Context context) {

        Template template = null;

        try {
            context.put("res", request.getSession().getAttribute("res"));
            template = Velocity.getTemplate("result.vm");
        } catch( Exception e ) {
            System.err.println("Exception caught: " + e.getMessage());
        }

        return template;
    }
}
