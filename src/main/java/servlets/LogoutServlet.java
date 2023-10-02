package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Otteniamo la sessione corrente (o creiamo una nuova se non esiste)
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            // Invalidiamo la sessione (effettuiamo il logout)
            session.invalidate();
        }
        
        // Reindirizziamo l'utente alla pagina di login o a una pagina di conferma del logout
        response.sendRedirect("login.html"); // Modificare l'URL a seconda delle tue esigenze
    }
}
