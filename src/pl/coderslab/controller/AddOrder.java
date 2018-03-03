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
 * Servlet implementation class AddOrder
 */
@WebServlet("/AddOrder")
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext()
		.getRequestDispatcher("/WEB-INF/views/addOrderForm.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		                             
		Order order = new Order();
		
		String dateOfAcceptanceForRepair = request.getParameter("dateOfAcceptanceForRepair");    
		order.setDateOfAcceptanceForRepair(dateOfAcceptanceForRepair);
		
		String plannedDateOfStartRepair = request.getParameter("plannedDateOfStartRepair");   
		order.setPlannedDateOfStartRepair(plannedDateOfStartRepair);
		
		String dateOfStartRepair = request.getParameter("dateOfStartRepair");         
		order.setDateOfStartRepair(dateOfStartRepair);
		
		String descriptionOfTheProblem = request.getParameter("descriptionOfTheProblem");     
		order.setDescriptionOfTheProblem(descriptionOfTheProblem);
		
		String descriptionOfTheRepair = request.getParameter("descriptionOfTheRepair");
		order.setDescriptionOfTheRepair(descriptionOfTheRepair);
		
		String status = request.getParameter("status");
		order.setStatus(status);
		
		String costOfRepairStr = request.getParameter("costOfRepair");
		double costOfRepair = Double.parseDouble(costOfRepairStr); 
		order.setCostOfRepair(costOfRepair);
		
		String cosOfUsedPartsStr = request.getParameter("costOfUsedParts");
		double costOfUsedParts  = Double.parseDouble(cosOfUsedPartsStr);
		order.setCostOfUsedParts(costOfUsedParts);
		
		String costOfOperatingHourOfEmployeeStr = request.getParameter("costOfOperatingHourOfEmployee");
		double costOfOperatingHourOfEmployee = Double.parseDouble(costOfOperatingHourOfEmployeeStr);
		order.setCostOfOperatingHourOfEmployee(costOfOperatingHourOfEmployee);
		
		String numberOfOperatingHoursStr = request.getParameter("numberOfOperatingHours");
		int numberOfOperatingHours = Integer.parseInt(numberOfOperatingHoursStr);
		order.setNumberOfOperatingHours(numberOfOperatingHours);
		
		String employeeIdStr = request.getParameter("employeeId");
		int employeeId = Integer.parseInt(employeeIdStr);
		order.setEmployeeId(employeeId);
		
		String vehicleIdStr = request.getParameter("vehicleId");
		int vehicleId = Integer.parseInt(vehicleIdStr);
		order.setVehicleId(vehicleId);
		
		try {
		OrderDAO.addOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
