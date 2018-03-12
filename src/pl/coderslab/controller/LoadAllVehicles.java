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
import pl.coderslab.entity.Vehicle;

/**
 * Servlet implementation class LoadAllVehicles
 */
@WebServlet("/LoadAllVehicles")
public class LoadAllVehicles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadAllVehicles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles = VehicleDAO.loadAll();
		request.setAttribute("vehicles", vehicles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getServletContext()
		.getRequestDispatcher("/WEB-INF/views/loadAllVehicles.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
