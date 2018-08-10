package com.reservationbb.pob.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reservationbb.pob.dao.ClientDao;

/**
 * Servlet implementation class Controlador3
 */
@WebServlet("/Controlador3")
public class Controlador3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ClientDao clientDao = new ClientDao();

		String deleteByIdInputString = request.getParameter("deleteByIdInput");
		// ES UN SUBMIT ..- NO HACE FALTA String btnDeleteRow = request.getParameter("btnDeleteRow");
		int deleteByIdInputInt = Integer.parseInt(deleteByIdInputString);
		try {
			clientDao.deleteRow(deleteByIdInputInt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
			
		
		// PASO EL FLUJO A LA JSP
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
