import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.html");
            return;
        }


        List<Course> courses = new ArrayList<>();
        courses.add(new Course("1053", "Java Basics", "Dr. Perera"));
        courses.add(new Course("2012", "Web Programming", "Dr. Silva"));
        courses.add(new Course("2031", "Database Systems", "Dr. Fernando"));
        courses.add(new Course("3103", "Serverside web programming", "Dr.Isuru Mdugalle"));
        courses.add(new Course("1074", "Python Fundamentals", "Dr. Wijesinghe"));
        courses.add(new Course("2091", "Data Structures", "Dr. Ranasinghe"));
        courses.add(new Course("2145", "Cloud Computing", "Dr. Jayawardena"));
        courses.add(new Course("3056", "Mobile App Development", "Dr. Gunawardana"));
        courses.add(new Course("3124", "Cybersecurity Basics", "Dr. Peiris"));
        courses.add(new Course("4087", "Machine Learning", "Dr. De Silva"));
        courses.add(new Course("4163", "Software Engineering", "Dr. Karunaratne"));


        List<Course> enrolled = (List<Course>) session.getAttribute("enrolledCourses");
        if (enrolled == null) {
            enrolled = new ArrayList<>();
            session.setAttribute("enrolledCourses", enrolled);
        }


        request.setAttribute("courses", courses);
        request.setAttribute("enrolledCourses", enrolled);
        request.setAttribute("username", session.getAttribute("username"));


        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
}