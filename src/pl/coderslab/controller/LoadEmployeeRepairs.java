package pl.coderslab.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.CustomerDAO;
import pl.coderslab.dao.EmployeeDAO;
import pl.coderslab.entity.Employee;
import pl.coderslab.entity.Order;

/**
 * Servlet implementation class LoadEmployeeRepairs
 */
@WebServlet("/LoadEmployeeRepairs")
public class LoadEmployeeRepairs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadEmployeeRepairs() {
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
		
		List<Order> employeeRepairs = new ArrayList<>();
		
		try {
			employeeRepairs = EmployeeDAO.showEmployeeRepairs(id);
			request.setAttribute("employeeRepairs", employeeRepairs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/loadEmployeeRepairs.jsp").forward(request, response);
	}

}
