package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.entity.Employee;

/**
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("employeeId"));
		
		try {
			Employee employee = EmployeeDAO.load(id);
			request.setAttribute("employee", employee);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		getServletContext()
		.getRequestDispatcher("/WEB-INF/views/updateEmployeeForm.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String note = request.getParameter("note");
		String costOfOperatingHour = request.getParameter("costOfOperatingHour");
		
		final String query = "UPDATE EMPLOYEE SET name=?, surname=?, address=?, phone_number=?, note=?, "
				+ "cost_of_operating_hour=? WHERE id=" + id + ";";
		
		List<String> params = EmployeeDAO.addEmployee(name, surname, address, phoneNumber, note, costOfOperatingHour);
		
		try {
			EmployeeDAO.updateEmployee(query, params);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getServletContext()
	 	.getRequestDispatcher("/WEB-INF/views/alertUpdateEmployee.jsp")
	 	.forward(request, response);
	}

}
