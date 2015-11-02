import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lzakharov on 21.10.15.
 */
@WebServlet(name = "StudentSearchServlet")
public class StudentSearchServlet extends HttpServlet {
    private Connection connection;

    @Override
    public void init() {
        DBConnection connection = new DBConnection();
        this.connection = DBConnection.connection;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String q = request.getParameter("q");
        String select = request.getParameter("select");
        System.out.println(select);

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT name FROM " + select +  " WHERE lower(name) LIKE ?");
            statement.setString(1, "%" + q.toLowerCase() + "%");
            ResultSet resultSet = statement.executeQuery();
            JSONArray jsonArray = new JSONArray();
            while (resultSet.next()) {
                jsonArray.put(resultSet.getString("name"));
            }

            JSONObject jsonObject = new JSONObject();
            response.setContentType("text/json");
            jsonObject.put("results", jsonArray);

            response.getWriter().print(jsonObject.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}