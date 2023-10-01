package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Sample servlet class for login related methods
 */
public class LoginServlet extends HttpServlet {
	
	private String getEncryptedUser() {
        // Implementa la logica per ottenere l'utente criptato
        // Restituisci l'utente criptato come una stringa
        return "encrypted_user";
        }
	private String getEncryptedPassword() {
        // Implementa la logica per ottenere l'utente criptato
        // Restituisci l'utente criptato come una stringa
        return "encrypted_password";
        }
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);

		//String userid = request.getParameter("userid");
		//String password = request.getParameter("password");
		String userid = getEncryptedUser();
                String password = getEncryptedPassword();

		if (password.equals("admin")) {
			out.print("Welcome, " + userid);
			HttpSession session = request.getSession();
			session.setAttribute("name", userid);
		} else {
			out.print("Sorry, username or password error!");
			request.getRequestDispatcher("login.html").include(request,
					response);
		}
		out.close();
	}

}
