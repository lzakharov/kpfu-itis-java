import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by levzaharov on 30.09.15.
 */
@WebServlet(name = "ResultServlet")
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        switch ((String)session.getAttribute("operation")) {
            case "symbols-cnt":
                writer.println("<p>Количество символов: " + symbolsCounter((String)session.getAttribute("text")) + "</p>");
                break;
            case "words-cnt":
                writer.println("Количество слов: " + wordsCounter((String)session.getAttribute("text")) + "</p>");
                break;
            case "sentences-cnt":
                writer.println("Количество предложений: " + sentencesCounter((String)session.getAttribute("text")) + "</p>");
                break;
            case "paragraphs-cnt":
                writer.println("Количество параграфов: " + paragraphsCounter((String)session.getAttribute("text")) + "</p>");
                break;
        }
    }

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
}
