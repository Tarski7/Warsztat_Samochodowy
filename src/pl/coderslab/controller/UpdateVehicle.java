package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.dao.VehicleDAO;
import pl.coderslab.entity.Employee;
import pl.coderslab.entity.Vehicle;

/**
 * Servlet implementation class UpdateVehicle
 */
@WebServlet("/UpdateVehicle")
public class UpdateVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateVehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("vehicleId"));

		try {
			Vehicle vehicle = VehicleDAO.load(id);
			request.setAttribute("vehicle", vehicle);
		} catch (Exception e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/WEB-INF/views/updateVehicleForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String model = request.getParameter("model");
		String brand = request.getParameter("brand");
		String yearOfProduction = request.getParameter("yearOfProduction");
		String registrationNumber = request.getParameter("registrationNumber");
		String dateOfNextTechnicalInspection = request.getParameter("dateOfNextTechnicalInspection");
		String customerId = request.getParameter("customerId");

		final String query = "UPDATE VEHICLE SET model=?, brand=?, year_of_production=?, registration_number=?, "
				+ "date_of_next_technical_inspection=?, customer_id=? WHERE id=" + id + ";";

		List<String> params = VehicleDAO.addVehicle(model, brand, yearOfProduction, registrationNumber,
				dateOfNextTechnicalInspection, customerId);

		try {
			VehicleDAO.updateVehicle(query, params);

		} catch (Exception e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/WEB-INF/views/alertUpdateEmployee.jsp").forward(request, response);
	}

}
