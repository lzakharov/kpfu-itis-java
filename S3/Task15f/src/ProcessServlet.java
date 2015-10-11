import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import org.apache.velocity.servlet.VelocityServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by levzaharov on 09.10.15.
 */
@WebServlet(name = "ProcessServlet")
public class ProcessServlet extends VelocityServlet {
    private String paragraphsCounter(String text) {
        return String.valueOf(text.split("\\t+").length);
    }

    private String sentencesCounter(String text) {
        return String.valueOf(text.split("\\.|!|\\?").length);
    }

    private String wordsCounter(String text) {
        return String.valueOf((text.split(" ")).length);
    }

    private String symbolsCounter(String text) {
        return String.valueOf(text.length());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String text = (String)request.getParameter("text");
        String res = null;

        switch (request.getParameter("operation")) {
            case "symbols-cnt":
                res = symbolsCounter(text);
                break;
            case "words-cnt":
                res = wordsCounter(text);
                break;
            case "sentences-cnt":
                res = sentencesCounter(text);
                break;
            case "paragraphs-cnt":
                res = paragraphsCounter(text);
                break;
        }

        session.setAttribute("res", res);
        response.sendRedirect("/result");
    }

    public Template handleRequest(HttpServletRequest request,
                                  HttpServletResponse response,
                                  Context context) {

        Template template = null;

        try {
            context.put("text", request.getParameter("text"));
            template = Velocity.getTemplate("process.vm");
        } catch( Exception e ) {
            System.err.println("Exception caught: " + e.getMessage());
        }

        return template;
    }
}
