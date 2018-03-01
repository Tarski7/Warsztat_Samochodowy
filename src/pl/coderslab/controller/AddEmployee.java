package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.service.DatabaseClient;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext()
		.getRequestDispatcher("/WEB-INF/views/addEmployeeForm.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String note = request.getParameter("note");
		String costOfOperatingHour = request.getParameter("costOfOperatingHour");
		
		final String query = "INSERT INTO EMPLOYEE(id, name, surname, address, phone_number, note, "
				+ "cost_of_operating_hour) VALUES(default, ?, ?, ?, ?, ?, ?);";
		
		List<String> employees = EmployeeDAO.addEmployee(name, surname, address, phoneNumber, note, costOfOperatingHour);
		
		try {
			DatabaseClient.add(query, employees);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getServletContext()
	 	.getRequestDispatcher("/WEB-INF/views/alertAddEmployee.jsp")
	 	.forward(request, response);
	}

}
