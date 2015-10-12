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
 * Created by levzaharov on 12.10.15.
 */
@WebServlet(name = "ShowBookServlet")
public class ShowBookServlet extends HttpServlet {
    private String name = null;
    private String author = null;
    private Integer year = null;
    private String publisher = null;
    private String description = null;
    private Integer rate = null;
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
        name = "Сиддхартха";
        author = "Герман Гессе";
        year = 2009;
        publisher = "АСТ, АСТ Москва";
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi mattis lacus elit, nec venenatis erat accumsan tempor. Aliquam vel nisl neque. Phasellus eu risus elementum, sodales ex non, luctus justo. Quisque mattis arcu sit amet odio sollicitudin faucibus. Etiam vitae dolor tincidunt, porta nisi at, varius massa. Proin nec risus eget nisi feugiat lobortis eu et nisl. Sed consectetur varius ligula at feugiat. Sed scelerisque odio turpis. Cras placerat dictum nisi, vitae ultricies mi convallis sed. Vivamus viverra et neque eget suscipit.";
        rate = 5;
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
        Template template = config.getTemplate("book_show.ftl");
        HashMap<String, Object> root = new HashMap<>();
        root.put("current_user", request.getSession().getAttribute("current_user"));
        root.put("name", name);
        root.put("author", author);
        root.put("year", year);
        root.put("description", description);
        root.put("publisher", publisher);
        root.put("comments", comments);
        String rateStr = "";
        for (int i = 0; i < rate; i++) {
            rateStr += "✩";
        }
        root.put("rate", rateStr);

        try {
            template.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
