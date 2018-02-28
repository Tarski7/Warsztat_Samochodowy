package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.VehicleDAO;
import pl.coderslab.service.DbEmployee;

/**
 * Servlet implementation class AddVehicle
 */
@WebServlet("/AddVehicle")
public class AddVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext()
		.getRequestDispatcher("/WEB-INF/views/addVehicleForm.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String model = request.getParameter("model");
		String brand = request.getParameter("brand");
		String yearOfProduction = request.getParameter("yearOfProduction");
		String registrationNumber = request.getParameter("registrationNumber");
		String dateOfNextTechnicalInspection = request.getParameter("dateOfNextTechnicalInspection");
		String customerId = request.getParameter("customerId");
		
		final String query = "INSERT INTO VEHICLE(id, model, brand, year_of_production, registration_number, "
				+ "date_of_next_technical_inspection, customer_id) VALUES(default, ?, ?, ?, ?, ?, ?);";
		
		List<String> vehicles = VehicleDAO.addVehicle(model, brand, yearOfProduction, registrationNumber, dateOfNextTechnicalInspection, customerId);
		
		try {
			DbEmployee.add(query, vehicles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getServletContext()
	 	.getRequestDispatcher("/WEB-INF/views/alertAddVehicle.jsp")
	 	.forward(request, response);
	}

}
