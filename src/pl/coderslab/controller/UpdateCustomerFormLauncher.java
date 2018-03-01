package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateCustomer
 */
@WebServlet("/UpdateCustomerFormLauncher")
public class UpdateCustomerFormLauncher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerFormLauncher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().
		getRequestDispatcher("/WEB-INF/views/updateCustomerForm.jsp").
		forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idStr = request.getParameter("idToEdit");
		int idToEdit = Integer.parseInt(idStr);
		
		HttpSession session = request.getSession();
		session.setAttribute("idToEdit", idToEdit);
		
		doGet(request, response);
	}
}
