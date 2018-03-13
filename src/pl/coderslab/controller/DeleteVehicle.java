package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.service.DatabaseClient;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("vehicleId"));
		
		final String query = "DELETE FROM VEHICLE WHERE id=?;";
		
		try {
			DatabaseClient.delete(query, id);
			getServletContext()
		 	.getRequestDispatcher("/WEB-INF/views/alertDeleteVehicle.jsp")
		 	.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			getServletContext()
		 	.getRequestDispatcher("/WEB-INF/views/alertFail.jsp")
		 	.forward(request, response);
		}
		
	}

}
