package pl.coderslab.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.OrderDAO;
import pl.coderslab.entity.Order;

/**
 * Servlet implementation class LoadAllOrders
 */
@WebServlet("/LoadAllOrders")
public class LoadAllOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadAllOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Order> orders = new ArrayList<>();
		orders = OrderDAO.loadAll();
		
		request.setAttribute("orders", orders);
		
		getServletContext().
		getRequestDispatcher("/WEB-INF/views/loadAllOrders.jsp").
		forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
