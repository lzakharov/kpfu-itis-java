import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import sun.reflect.generics.repository.ClassRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by lzakharov on 16.10.15.
 */
@WebServlet(name = "StudentsClassesServlet")
public class StudentsClassesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration config = ConfigSingleton.getConfig(getServletContext());
        Template template = config.getTemplate("students-classes.ftl");
        Repository repository = new Repository();

        LinkedList<Attendance> studentsClasses = AttendancesRepository.getStudentsClassesIdsBetweenYears(1992, 1998);
        String[][] res = new String[studentsClasses.size()][2];

        for (int i = 0; i < studentsClasses.size(); i++) {
            res[i][0] = studentsClasses.get(i).getStudent().getName();
            res[i][1] = studentsClasses.get(i).getSchoolClass().getName();
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
