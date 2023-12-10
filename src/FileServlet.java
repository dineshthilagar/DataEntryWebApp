import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/saveData")
public class FileServlet extends HttpServlet {
    private static final String FILE_PATH = "/data.txt";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userData = request.getParameter("userData");

        // Validate if user data is not empty
        if (userData == null || userData.trim().isEmpty()) {
            response.getWriter().write("Please enter data before saving.");
            return;
        }

        // Append user data to the file
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH, true)))) {
            writer.println(userData);
        }

        response.getWriter().write("Data saved successfully.");
    }
}


