import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import org.apache.velocity.servlet.VelocityServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by levzaharov on 10.10.15.
 */
@WebServlet(name = "DateServlet")
public class DateServlet extends VelocityServlet {
    public Template handleRequest( HttpServletRequest request,
                                   HttpServletResponse response,
                                   Context context ) {

        Template template = null;

        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date date = new Date();

        try {
            context.put("date", dateFormat.format(date));
            template = Velocity.getTemplate("date.vm");
        } catch( Exception e ) {
            System.err.println("Exception caught: " + e.getMessage());
        }

        return template;
    }
}
