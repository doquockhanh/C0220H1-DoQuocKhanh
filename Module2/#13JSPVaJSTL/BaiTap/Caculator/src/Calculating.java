import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Calculating", urlPatterns = "/calculating")
public class Calculating extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstOperand = request.getParameter("firstOperand");
        String secondOperand = request.getParameter("secondOperand");
        String x = "";
        String operator = request.getParameter("operator");
        if (operator.equals("div")){
            try {
                int a = Integer.parseInt(firstOperand)/Integer.parseInt(secondOperand);
                request.setAttribute("result", a);
            }catch (Exception e){
                x += "a";
                request.setAttribute("exception", x);
            }
        }else if (operator.equals("add")){
            int a = Integer.parseInt(firstOperand) + Integer.parseInt(secondOperand);
            request.setAttribute("result", a);
        }else if (operator.equals("sub")){
            int a = Integer.parseInt(firstOperand)-Integer.parseInt(secondOperand);
            request.setAttribute("result", a);
        }else {
            int a = Integer.parseInt(firstOperand)*Integer.parseInt(secondOperand);
            request.setAttribute("result", a);
        }

        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
