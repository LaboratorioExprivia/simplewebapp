package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Validazione dei parametri in ingresso
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");

        if (userid != null && password != null && isValidUser(userid, password)) {
            // Autenticazione riuscita, crea una sessione
            HttpSession session = request.getSession(true);
            session.setAttribute("name", userid);

            // Reindirizza a una pagina di benvenuto
            response.sendRedirect("welcome.jsp");
        } else {
            // Autenticazione fallita, restituisci un errore
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Autenticazione fallita");
        }
    }

    // Metodo per la verifica delle credenziali (da implementare in modo sicuro)
    private boolean isValidUser(String userid, String password) {
        // Qui dovresti implementare la verifica sicura delle credenziali,
        // ad esempio, confrontando con un database o utilizzando l'hashing delle password.
        // Restituisci true se l'utente è valido, altrimenti false.
        return userid.equals("admin") && password.equals("adminPassword");
    }
}
