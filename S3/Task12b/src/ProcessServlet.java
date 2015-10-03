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
@WebServlet(name = "ProcessServlet")
public class ProcessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("text", request.getParameter("text"));
        session.setAttribute("operation", request.getParameter("operation"));
        response.sendRedirect("/result");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();

        writer.println("<form name='process' action='/process' method='POST'>");
        if (session.getAttribute("text") != null) {
            writer.println("<textarea name='text' value='" + session.getAttribute("text") + "'></textarea><br>");
        } else {
            writer.println("<textarea name='text' type='textarea'></textarea><br>");
        }
        writer.println("<input name='process' type='submit' value='Process!'>" +
                       "<select name=\"operation\">" +
                       "<option disabled>Выберите операцию</option>" +
                       "<option value=\"symbols-cnt\">Количество символов</option>" +
                       "<option value=\"words-cnt\">Количество слов</option>" +
                       "<option value=\"sentences-cnt\">Количество предложений</option>" +
                       "<option value=\"paragraphs-cnt\">Количество абзацев</option>" +
                       "</select>" +
                       "</form>");
    }
}
