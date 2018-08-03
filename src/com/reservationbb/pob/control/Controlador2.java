package com.reservationbb.pob.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reservationbb.pob.dao.ManagementDao;
import com.reservationbb.pob.model.Client;

@WebServlet("/Controlador2")
public class Controlador2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controlador2() {
		super();
	}

	// -------------------------------------GET----- CONTROLADOR2------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// Recojo info del botón para eliminar los registros de la base de datos

		ManagementDao md2 = new ManagementDao();
		
			try {
				md2.delete();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		// PASO EL FLUJO A LA JSP
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	// -------------------------------------POST----- CONTROLADOR2------------

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
		String setPriceStringBtn = request.getParameter("setPriceBtn");
		String inputPriceString = request.getParameter("inputPrice");
		Client cli = new Client();
		if (setPriceStringBtn != null) {
			int newPriceInt = Integer.parseInt(inputPriceString);
			
			
			cli.setPricePerNight(newPriceInt);
			System.out.println("Prueba ... jsuto después del SET PRICE");
			 request.setAttribute("newPrice", newPriceInt);
			 
				// PASO EL FLUJO A LA JSP
		/**
		 * 	 request.setAttribute("newPrice", newPriceInt);
		 */
			/*RequestDispatcher rd2 = request.getRequestDispatcher("index.jsp");
			rd2.forward(request, response);*/
		
		}


	}

}
