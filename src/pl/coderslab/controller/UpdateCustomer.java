package pl.coderslab.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.dao.CustomerDAO;
import pl.coderslab.entity.Customer;

/**
 * Servlet implementation class UpdateCustomer
 */
@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("/Warsztat_Samochodowy/LoadAllCustomers");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int idToEdit = (int) session.getAttribute("idToEdit");
		session.removeAttribute("idToEdit");

		String newName = request.getParameter("newName");
		String newLastName = request.getParameter("newLastName");
		String newDateOfBirth = request.getParameter("newDateOfBirth");

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Customer customer = new Customer();
		customer.setId(idToEdit);

		if (!newName.isEmpty()) {
			customer.setName(newName);
		}
		if (!newLastName.isEmpty()) {
			customer.setLastName(newLastName);
		}
		if (!newDateOfBirth.isEmpty()) {
			try {
				Date date = format.parse(newDateOfBirth);
				customer.setDateOfBirth(newDateOfBirth);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println(customer.toString());

		try {
			CustomerDAO.updateCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
