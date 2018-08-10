package com.reservationbb.pob.control;

import java.io.IOException;
import java.sql.SQLException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reservationbb.pob.dao.ClientDao;
import com.reservationbb.pob.dao.ManagementDao;
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

	ClientDao clientDao = new ClientDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// SET CARACTER ENCODING -> Para que los valores recogidos por el servlet
		// mantengan el UTF-8
		request.setCharacterEncoding("UTF-8");
		ClientDao clientDao = new ClientDao();
		ManagementDao md = new ManagementDao();
		Client client = new Client();
		List<Client> lista = new ArrayList<>();
		// Recojo los datos del formulario para Client
		String nombre = request.getParameter("name");
		String apellidos = request.getParameter("surname");
		String nacionalidad = request.getParameter("nationality");
		int telefono = Integer.parseInt(request.getParameter("telephone"));
		String checkInString = request.getParameter("checkIn");
		String checkOutString = request.getParameter("checkOut");

		LocalDate checkIn = LocalDate.parse(checkInString);
		LocalDate checkOut = LocalDate.parse(checkOutString);
		String totalNightsString = request.getParameter("totalNights");

		String priceString = request.getParameter("inputPrice");
		int newPriceInt = Integer.parseInt(priceString);

		if ((priceString != null) && (newPriceInt > 0)) {
			client.setPricePerNight(newPriceInt);
		}

		System.out.println("Prueba ... jsuto despu�s del SET PRICE");

		int deposit = Integer.parseInt(request.getParameter("deposit"));
		int totalNightsInt = Integer.parseInt(totalNightsString);
		int totalRoomsInt = Integer.parseInt(request.getParameter("totalRooms"));

		int gananciaCliente = md.gananciaCliente(totalNightsInt, newPriceInt, totalRoomsInt, deposit);
		request.setAttribute("gananciaCliente", gananciaCliente);

		// request.setAttribute("newPrice", newPriceInt);
		// Creo un cliente con los datos del formulario
		client = new Client(nombre, apellidos, nacionalidad, telefono, totalNightsInt, checkIn, checkOut, deposit,
				totalRoomsInt, newPriceInt, gananciaCliente);

		try {
			clientDao.insert(client);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// A�ado el nuevo objeto cliente a la lista
		lista.add(client);
		// Dejo la lista en el request NO HACE FALTA QUE DEJE NADA EN REQUEST por ahora
		// request.setAttribute("lista", lista);

		// PASO EL FLUJO A LA JSP
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

	}

}
