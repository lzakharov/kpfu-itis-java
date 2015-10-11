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
import java.util.HashMap;

/**
 * Created by levzaharov on 09.10.15.
 */
@WebServlet(name = "ProcessServlet")
public class ProcessServlet extends HttpServlet {
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        Configuration config = ConfigSingleton.getConfig(getServletContext());
        Template template = config.getTemplate("/process.ftl");
        HashMap<String, Object> root = new HashMap<>();
        root.put("text", request.getParameter("text"));

        try {
            template.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
