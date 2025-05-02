import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String courseId = request.getParameter("courseId");
        HttpSession session = request.getSession();

        List<Course> enrolled = (List<Course>) session.getAttribute("enrolledCourses");
        if (enrolled == null) {
            enrolled = new ArrayList<>();
        }

        Course course = null;
        switch (courseId) {
            case "1053":
                course = new Course("1053", "Java Basics", "Dr. Perera");
                break;
            case "2012":
                course = new Course("2012", "Web Programming", "Dr. Silva");
                break;
            case "2031":
                course = new Course("2031", "Database Systems", "Dr. Fernando");
                break;
            case "3103":
                course = new Course("3103","Serverside web programming","Dr. Isuru Madugale");
                break;
            case "1074":
                course = new Course("1074", "Python Fundamentals", "Dr. Wijesinghe");
                break;
            case "2091":
                course = new Course("2091", "Data Structures", "Dr. Ranasinghe");
                break;
            case "2145":
                course = new Course("2145", "Cloud Computing", "Dr. Jayawardena");
                break;
            case "3056":
                course = new Course("3056", "Mobile App Development", "Dr. Gunawardana");
                break;
            case "3124":
                course = new Course("3124", "Cybersecurity Basics", "Dr. Peiris");
                break;
            case "4087":
                course = new Course("4087", "Machine Learning", "Dr. De Silva");
                break;
            case "4163":
                course = new Course("4163", "Software Engineering", "Dr. Karunaratne");
                break;
        }

        if (course != null && !enrolled.stream().anyMatch(c -> c.getId().equals(courseId))) {
            enrolled.add(course);
            session.setAttribute("enrolledCourses", enrolled);
        }

        response.sendRedirect("DashboardServlet");
    }
}

