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
import java.util.LinkedList;
import java.util.List;

/**
 * Created by levzaharov on 13.10.15.
 */
@WebServlet(name = "ShowArticleServlet")
public class ShowArticleServlet extends HttpServlet {
    private String author = null;
    private String title = null;
    private String text = null;
    private String date = null;
    private List<Comment> comments = null;

    public class Comment {
        public String name;
        public String time;
        public String text;

        public Comment(String name, String time, String text) {
            this.name = name;
            this.time = time;
            this.text = text;
        }

        public String getName() {
            return name;
        }

        public String getTime() {
            return time;
        }

        public String getText() {
            return text;
        }
    }

    @Override
    public void init() {
        title = "Статья";
        author = "Лев";
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi mattis lacus elit, nec venenatis erat accumsan tempor. Aliquam vel nisl neque. Phasellus eu risus elementum, sodales ex non, luctus justo. Quisque mattis arcu sit amet odio sollicitudin faucibus. Etiam vitae dolor tincidunt, porta nisi at, varius massa. Proin nec risus eget nisi feugiat lobortis eu et nisl. Sed consectetur varius ligula at feugiat. Sed scelerisque odio turpis. Cras placerat dictum nisi, vitae ultricies mi convallis sed. Vivamus viverra et neque eget suscipit.";
        date = "29 September 2015";
        comments = new LinkedList<>();
        comments.add(new Comment("Иван", "Время", "Комментарий Ивана"));
        comments.add(new Comment("Василий", "Время", "Комментарий Василий"));
        comments.add(new Comment("Лев", "Время", "Комментарий Лев"));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        Configuration config = ConfigSingleton.getConfig(getServletContext());
        Template template = config.getTemplate("article_show.ftl");
        HashMap<String, Object> root = new HashMap<>();
        root.put("current_user", request.getSession().getAttribute("current_user"));
        root.put("title", title);
        root.put("author", author);
        root.put("text", text);
        root.put("date", date);
        root.put("comments", comments);

        try {
            template.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
