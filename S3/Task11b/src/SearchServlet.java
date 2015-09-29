import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by levzaharov on 29.09.15.
 */
@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        switch (request.getPathInfo().substring(1)) {
            case "baidu":
                writer.write("<form name=\"search-baidu\" action=\"http://www.baidu.com/s\">" +
                        "<input name=\"wd\" type=\"text\">" +
                        "<input name=\"submit\" type=\"submit\">" +
                        "</form>");

                break;
            case "bing":
                writer.write("<form name=\"search-bing\" action=\"http://www.bing.com/search\">" +
                        "<input name=\"q\" type=\"text\">" +
                        "<input name=\"submit\" type=\"submit\">" +
                        "</form>");

                break;
            case "yahoo":
                writer.write("<form name=\"search-yahoo\" action=\"https://search.yahoo.com/search\">" +
                        "<input name=\"p\" type=\"text\">" +
                        "<input name=\"submit\" type=\"submit\">" +
                        "</form>");

                break;
            case "aol":
                writer.write("<form name=\"search-aol\" action=\"http://search.aol.com/aol/search\">" +
                        "<input name=\"q\" type=\"text\">" +
                        "<input name=\"submit\" type=\"submit\">" +
                        "</form>");

                break;
            default:
                response.sendError(400, "Bad request");
        }

        writer.close();
    }
}
