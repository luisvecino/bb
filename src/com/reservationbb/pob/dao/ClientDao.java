package com.reservationbb.pob.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.reservationbb.pob.service.Connect;
import com.reservationbb.pob.model.Client;

public class ClientDao {
	public Connect con;
	String sql = null;
	private Connection conection = null;
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

// GET ID
/*	public List<Integer> id() throws SQLException {
		int id = 0;
		 List<Integer> list = new ArrayList<>();
		sql = "Select ID FROM client;";
		try {
			conection = Connect.getConnection();
			st = conection.createStatement();
			rs =st.executeQuery(sql);
			
			while(rs.next()) {
				id = rs.getInt("ID");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
	
		
		return list;
		
	}*/
	
	// iNSERTAR CLIENTES

	public boolean insert(Client client) throws SQLException {
		sql = "Insert into client"
				+"(Nombre, Apellidos, Nacionalidad, Telefono, Noches, CheckIn, "
				+ "CheckOut, Deposito, Total_Habitaciones) values "
				 + "(?,?,?,?,?,?,?,?,?)";
		conection = Connect.getConnection();
		ps = conection.prepareStatement(sql);
		//ps.setInt(0, client.getId());
		ps.setString(1, client.getName());
		ps.setString(2, client.getSurname());
		ps.setString(3, client.getNationality());
		ps.setInt(4, client.getTelephone());
		ps.setInt(5, client.getTotalNights());
		ps.setObject ( 6 , client.getCheckIn() );
		ps.setObject ( 7 , client.getCheckOut() );

		//ps.setDate(6, client.getCheckIn());
		//ps.setDate(7, client.getCheckOut());
		ps.setInt(8, client.getDeposit());
		ps.setInt(9, client.getTotalRooms());
		

		/*"INSERT INTO DBUSER"
		+ "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) VALUES"
		+ "(?,?,?,?)";*/
		boolean insertar = ps.executeUpdate() > 0;

		return insertar;
	}

	
	 //  LISTAR TODOS LOS CLIENTES 
	// cREO UN MÉTODO QUE ME DEVUELVE UNA LISTA DE CLIENTES
	public List<Client> clientList() throws SQLException {
	  //Creo unalista vacía
	  List<Client> list = new ArrayList<Client>();
	  sql = "SELECT * FROM client";
	  conection = Connect.getConnection();
	  st = conection.createStatement();
	  rs = st.executeQuery(sql);
	  while (rs.next()) {
		  // int id = rs.getInt("ID");
		  String name = rs.getString("Nombre");
		  String surname = rs.getString("Apellidos");
		  String nacionalidad = rs.getString("Nacionalidad");
		  int tel = rs.getInt("Telefono");
		  int totalNights = rs.getInt(6);
		  LocalDate checkIn = rs.getDate(7).toLocalDate();
		  LocalDate checkOut = rs.getDate(8).toLocalDate();
		  int deposit = rs.getInt(9);
		  int totalRooms = rs.getInt(10);

		
	  Client client = new Client(name,surname,nacionalidad,tel,totalNights,checkIn,checkOut,deposit,totalRooms);
	  list.add(client);
	  
	  } 
	  st.close();
	  Connect.close(conection);
	  return list; 
	  }
	

}
