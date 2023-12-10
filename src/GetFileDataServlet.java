import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet("/getFileData")
public class GetFileDataServlet extends HttpServlet {
    private static final String FILE_PATH = "/data.txt";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Read file data and send it as the response
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            StringBuilder fileData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileData.append(line).append("\n");
            }
            response.getWriter().write(fileData.toString());
        }
    }
}