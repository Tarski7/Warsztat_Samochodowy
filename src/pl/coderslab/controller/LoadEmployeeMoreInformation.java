package pl.coderslab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.entity.Employee;

/**
 * Servlet implementation class LoadEmployeeMoreInformation
 */
@WebServlet("/LoadEmployeeMoreInformation")
public class LoadEmployeeMoreInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadEmployeeMoreInformation() {
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
		
		int id = Integer.parseInt(request.getParameter("employeeId"));
		
		try {
		Employee employee = EmployeeDAO.load(id);
		request.setAttribute("employee", employee);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		getServletContext()
		.getRequestDispatcher("/WEB-INF/views/loadEmployeeMoreInformation.jsp")
		.forward(request, response);
	}

}
