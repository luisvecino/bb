package com.reservationbb.pob.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	// iNSERTAR CLIENTES

	public boolean insert(Client client) throws SQLException {
		sql = "Insert into client (ID, Nombre, Apellidos, Nacionalidad, Telefono) values(?,?,?,?,?)";
		conection = Connect.getConnection();
		ps = conection.prepareStatement(sql);
		ps.setInt(1, (client.getId())+ 1);
		ps.setString(2, client.getName());
		ps.setString(3, client.getSurname());
		ps.setString(4, client.getNationality());
		ps.setInt(5, client.getTelephone());

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
	  int id = 1;
	  while (rs.next()) {
		  id++;
		  String name = rs.getString("Nombre");
		  String surname = rs.getString("Apellidos");
		  String nacionalidad = rs.getString("Nacionalidad");
		  int tel = rs.getInt("Telefono");
	  
	  Client client = new Client(id, name,surname,nacionalidad,tel);
	  list.add(client);
	  
	  } 
	  st.close();
	  Connect.close(conection);
	  return list; 
	  }
	 

}
