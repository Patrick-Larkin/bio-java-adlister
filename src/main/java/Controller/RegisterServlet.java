package Controller;

import Dao.DaoFactory;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getSession().getAttribute("user") != null) {
			response.sendRedirect("/profile");
			return;
		}
		String errorMessage = (String) session.getAttribute("registerError");
		if (errorMessage != null) {
			request.setAttribute("registerError", errorMessage);
			session.removeAttribute("registerError");
		}
		request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}

	//Todo: Streamline statements
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("password_confirm");

		// TODO: More ways to secure password?
		boolean inputHasErrors = username.isEmpty()
						|| email.isEmpty()
						|| password.isEmpty()
						|| (!password.equals(passwordConfirm));

		if (inputHasErrors) {
			request.getSession().setAttribute("registerError", "There was an error registering you.");
			response.sendRedirect("/register");
			return;
		}

		User user = new User(username, email, password);
		DaoFactory.getUsersDao().insert(user);
		try {
			request.getRequestDispatcher("/login").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
