package com.reservationbb.pob.control;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reservationbb.pob.dao.ClientDao;
import com.reservationbb.pob.model.Client;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controlador() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		ClientDao clientDao = new ClientDao();
		List <Client> lista = new ArrayList<>();
	//	Client cliente = new Client();

		
		// Recojo los datos del formulario para Client
		String nombre = request.getParameter("name");
		String apellido = request.getParameter("surname");
		String nacionalidad = request.getParameter("nationality");
		int telefono = Integer.parseInt(request.getParameter("telephone"));
		int id = (int) (Math.random()*1000)+500;

		// Creo un cliente con los datos del formulario
		Client client = new Client( id, nombre, apellido, nacionalidad, telefono);
		// Recojo los datos del formulario para Management
	//	String checkInString = request.getParameter("checkIn");
	//	String checkOutString = request.getParameter("checkOut");

	
    //    LocalDate checkIn = LocalDate.parse(checkInString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
     //   LocalDate checkOut = LocalDate.parse(checkOutString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		String numRoomsString = request.getParameter("numberOfRooms");
		String numNochesString = request.getParameter("numberNochesString");

		if((numRoomsString != null) && (numNochesString != null))	{
		int numRooms = Integer.parseInt(numRoomsString);
		int numNoches = Integer.parseInt(numNochesString);
		}
		
		double deposit = Double.parseDouble(request.getParameter("deposit"));
		
		
		 try {
			clientDao.insert(client);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
		
		 
		 //Añado el nuevo objeto cliente a la lista
	//		lista.add(client);
			// Dejo la lista en el request NO HACE FALTA QUE DEJE NADA EN REQUEST
		// request.setAttribute("lista", lista);
		 
		 // PASO EL FLUJO A LA JSP
		 RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		 rd.forward(request, response);
		
	}

}
