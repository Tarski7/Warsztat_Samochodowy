package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.OrderDAO;
import pl.coderslab.entity.Order;

/**
 * Servlet implementation class ChangeStatusOfOrder
 */
@WebServlet("/ChangeStatusOfOrder")
public class ChangeStatusOfOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeStatusOfOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		try {
			Order order = OrderDAO.loadChosenOrder(id);
			request.setAttribute("order", order);
		} catch (Exception e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/WEB-INF/views/changeStatusForm.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");

		try {
			OrderDAO.updateOrderStatus(id, status);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("/Warsztat_samochodowy/LoadAllOrders");

	}

}
