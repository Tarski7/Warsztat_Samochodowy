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
import pl.coderslab.entity.Customer;

/**
 * Servlet implementation class LoadSearchedCustomers
 */
@WebServlet("/LoadSearchedCustomers")
public class LoadSearchedCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadSearchedCustomers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Customer> customers = new ArrayList<>();
		
		String searchedLastName = request.getParameter("lastName");
		
		try {
		customers = CustomerDAO.searchCustomerByLastName(searchedLastName);
		request.setAttribute("customers", customers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getServletContext().
		getRequestDispatcher("/WEB-INF/views/loadAllCustomers.jsp").
		forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
