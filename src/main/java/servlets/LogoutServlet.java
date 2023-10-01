package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Ottieni la sessione corrente
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Invalida la sessione solo se esiste
            session.invalidate();
        }

        // Reindirizza l'utente alla pagina di login o a una pagina di conferma del logout
        response.sendRedirect("login.html"); // Modifica l'URL in base alla tua struttura di directory

        // Alternativamente, puoi restituire un messaggio di conferma di logout
        // PrintWriter out = response.getWriter();
        // out.println("Logout avvenuto con successo!");
    }
}
