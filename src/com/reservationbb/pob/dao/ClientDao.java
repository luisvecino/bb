package com.reservationbb.pob.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.reservationbb.pob.service.Connect;
import com.reservationbb.pob.model.Client;

public class ClientDao {
	public Connect con;
	String sql = null;
	protected Connection conection = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	Client client = new Client();

	public ClientDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Connect();
	}

	public ClientDao() {

	}

	// iNSERTAR CLIENTES
	public boolean insert(Client client) throws SQLException {
		sql = "Insert into client" + "(Nombre, Apellidos, Nacionalidad, Telefono, Noches, CheckIn, "
				+ "CheckOut, Deposito, Total_Habitaciones, PrecioPorNoche, GananciaXcliente) values "
				+ "(?,?,?,?,?,?,?,?,?,?,?)";
		conection = Connect.getConnection();
		ps = conection.prepareStatement(sql);
		// ps.setInt(0, client.getId());
		ps.setString(1, client.getName());
		ps.setString(2, client.getSurname());
		ps.setString(3, client.getNationality());
		ps.setInt(4, client.getTelephone());
		ps.setInt(5, client.getTotalNights());
		ps.setObject(6, client.getCheckIn());
		ps.setObject(7, client.getCheckOut());
		ps.setInt(8, client.getDeposit());
		ps.setInt(9, client.getTotalRooms());
		ps.setInt(10, client.getPricePerNight());
		ps.setInt(11, client.getGananciaXcliente());

		boolean insertar = ps.executeUpdate() > 0;
		return insertar;

	}

	// CREAR METODO QUE ME DE LA ID DE LA DB

	/*
	 * public int id() throws SQLException { int id = 0; sql
	 * =" SELECT ID FROM CLIENT;"; conection = Connect.getConnection(); st =
	 * conection.createStatement(); rs = st.executeQuery(sql);
	 * 
	 * return id; }
	 */

	// CREAR MÉTODO PARA ELIMINAR 1 REGISTRO DE LA BASE DE DATOS... SI ID = ... ->
	// BORRA
	// NO FUNCIONA... ES MÁS FÁCIL SI PONES UN ID EN UN INPUT TEXT Y BORRAS ESA ID
	// EN CONCRETO

	public void deleteRow(int id) throws SQLException {
		

		sql = "DELETE from client WHERE id = '" + id + "';";

		conection = Connect.getConnection();

		st = conection.createStatement();

		//ps.setInt(1, id);
		st.executeUpdate(sql);


	}

	// CREAR METODO PARA EDITAR UN REGISTRO ... podrÃ­a volver a salir el Model y
	// machacar lo anterior

	// LISTAR TODOS LOS CLIENTES
	// CREO UN Mï¿½TODO QUE ME DEVUELVE UNA LISTA DE CLIENTES
	public List<Client> clientList() throws SQLException {
		// Creo unalista vacï¿½a
		List<Client> list = new ArrayList<Client>();
		sql = "SELECT * FROM client";
		conection = Connect.getConnection();
		st = conection.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("Nombre");
			String surname = rs.getString("Apellidos");
			String nacionalidad = rs.getString("Nacionalidad");
			int tel = rs.getInt("Telefono");
			int totalNights = rs.getInt(6);
			LocalDate checkIn = rs.getDate(7).toLocalDate();
			LocalDate checkOut = rs.getDate(8).toLocalDate();
			int deposit = rs.getInt(9);
			int totalRooms = rs.getInt(10);
			int pricePerNight = rs.getInt(11);
			int gananciaxCliente = rs.getInt(12);

			Client client = new Client(id, name, surname, nacionalidad, tel, totalNights, checkIn, checkOut, deposit,
					totalRooms, pricePerNight, gananciaxCliente);
			list.add(client);

		}
		st.close();
		Connect.close(conection);
		return list;
	}

}
