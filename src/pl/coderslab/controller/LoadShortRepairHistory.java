package pl.coderslab.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.VehicleDAO;
import pl.coderslab.entity.Order;

/**
 * Servlet implementation class LoadShortRepairHistory
 */
@WebServlet("/LoadShortRepairHistory")
public class LoadShortRepairHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadShortRepairHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		
		List<Order> repairHistory = new ArrayList<>();
		
		repairHistory = VehicleDAO.showRepairHistory(vehicleId);
		request.setAttribute("repairHistory", repairHistory);
		
		getServletContext().
		getRequestDispatcher("/WEB-INF/views/loadShortRepairHistory.jsp").
		forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
