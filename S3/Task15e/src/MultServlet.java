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
@WebServlet(name = "MultServlet")
public class MultServlet extends VelocityServlet {
    public Template handleRequest( HttpServletRequest request,
                                   HttpServletResponse response,
                                   Context context ) throws IOException {

        Template template = null;

        String requestArgs = request.getPathInfo();
        String[] args = requestArgs.substring(1).split("/");

        try {
            context.put("res", Integer.parseInt(args[0]) * Integer.parseInt(args[1]));
            template = Velocity.getTemplate("add.vm");
        } catch (NumberFormatException e) {
            response.sendError(400, "Bad request");
        } catch( Exception e ) {
            System.err.println("Exception caught: " + e.getMessage());
        }

        return template;
    }
}
