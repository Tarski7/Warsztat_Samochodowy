package pl.coderslab.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.CustomerDAO;
import pl.coderslab.entity.Vehicle;

/**
 * Servlet implementation class LoadCustomerCars
 */
@WebServlet("/LoadCustomerCars")
public class LoadCustomerCars extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadCustomerCars() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Vehicle> customerCars = new ArrayList<>();

		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);

		try {
			customerCars = CustomerDAO.showCustomerCars(id);
			request.setAttribute("customerCars", customerCars);
		} catch (Exception e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/WEB-INF/views/loadCustomerCars.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
