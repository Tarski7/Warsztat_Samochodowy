package pl.coderslab.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.service.DbEmployee;
import pl.coderslab.service.DbVehicle;

/**
 * Servlet implementation class DeleteVehicle
 */
@WebServlet("/DeleteVehicle")
public class DeleteVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteVehicle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext()
		.getRequestDispatcher("/WEB-INF/views/deleteVehicleForm.jsp")
		.forward(request, response);
		
		PrintWriter pw = response.getWriter();
		pw.append("Employee has been deleted!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("vehicleId"));
		
		final String query = "DELETE FROM VEHICLE WHERE id=?;";
		
		try {
			DbVehicle.delete(query, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}