package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.ClientDao;
import pl.coderslab.service.DbClient;

/**
 * Servlet implementation class addClientController
 */
@WebServlet("/add_client")
public class addClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addClientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		getServletContext()
		.getRequestDispatcher("/WEB-INF/views/addClientForm.jsp")
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		String dateOfBirth = request.getParameter("dateOfBirth");
		
		String query = "INSERT INTO CUSTOMER VALUES(default, ?, ?, ?);";
		List<String> attributes = ClientDao.addClientList(name, lastName, dateOfBirth);
		
		try {
		DbClient.add(query, attributes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
