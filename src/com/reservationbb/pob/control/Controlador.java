package com.reservationbb.pob.control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		ClientDao clientDao = new ClientDao();
		Client client = new Client();
		List<Client> lista = new ArrayList<>();
		//int id = client.getId();
		// Recojo los datos del formulario para Client
		String nombre = request.getParameter("name");
		String apellidos = request.getParameter("surname");
		String nacionalidad = request.getParameter("nationality");
		int telefono = Integer.parseInt(request.getParameter("telephone"));

		 String checkInString = request.getParameter("checkIn");
		 String checkOutString = request.getParameter("checkOut");

		// Takes the date from the form in String and converts it java.util.date which
		// is how the buisness object is written
		   LocalDate checkIn = LocalDate.parse(checkInString);
		   LocalDate checkOut = LocalDate.parse(checkOutString);


		int deposit = Integer.parseInt(request.getParameter("deposit"));
		String totalNightsString = request.getParameter("totalNights");
		int totalNights = Integer.parseInt(totalNightsString);
		int totalRooms = Integer.parseInt(request.getParameter("totalRooms"));

		// Creo un cliente con los datos del formulario
		 client = new Client(nombre, apellidos, nacionalidad, telefono, totalNights, checkIn, checkOut, deposit,
				totalRooms);

		try {
			clientDao.insert(client);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Añado el nuevo objeto cliente a la lista
		lista.add(client);
		// Dejo la lista en el request NO HACE FALTA QUE DEJE NADA EN REQUEST
		// request.setAttribute("lista", lista);

		// PASO EL FLUJO A LA JSP
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

	}

}
