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

/**
 * Created by lzakharov on 18.10.15.
 */
@WebServlet(name = "HoraceSlughornStudentsServlet")
public class HoraceSlughornStudentsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration config = ConfigSingleton.getConfig(getServletContext());
        Template template = config.getTemplate("horace_slughorn_students.ftl");
        Repository repository = new Repository();

        LinkedList<Attendance> list = AttendancesRepository.getStudentsByTeacherName("Horace Slughorn");

        String[][] res = new String[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i).getStudent().getName();
            res[i][1] = String.valueOf(list.get(i).getYear());
        }

        HashMap<String, Object> root = new HashMap<>();
        root.put("res", res);

        try {
            template.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
