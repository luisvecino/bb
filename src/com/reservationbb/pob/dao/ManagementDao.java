package com.reservationbb.pob.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.reservationbb.pob.service.Connect;

public class ManagementDao extends ClientDao {
	
	//METODO DELETE TABLE
	public boolean delete() throws SQLException {
		Connection conn = Connect.getConnection();
		boolean borrar = false;
		
		sql = "TRUNCATE TABLE client;";
		st = conn.createStatement();
		st.executeUpdate(sql);
		
		st.close();
		Connect.close(conection);
		
		borrar = true;
		return borrar;
		  
	}
	
	//MÉTODO GANANCIA TOTAL POR CLIENTE
	public int gananciaCliente(int totalDias , int precio, int numHab , int deposito) {
		
		int gananciaCliente = ((precio*totalDias)*numHab)-deposito;
		
		return gananciaCliente;
	}
	
	// CREAR método para la ganancia total mensual, es decir, la suma de todas las ganancias totales durante un determinado mes
	//CRER DB Y TABLA
    
	/*public void createDatabase() throws SQLException {
		Connection conn = Connect.getConnection();
		sql = "CREATE database bb;";
		st = conn.createStatement();
		st.executeUpdate(sql);
		
		st.close();
		conn.close();
		
			};
	
	public void createTable() throws SQLException {
		sql = "CREATE TABLE client\r\n" + 
				"(ID integer NOT NULL auto_increment primary key,\r\n" + 
				"Nombre varchar(50),\r\n" + 
				"Apellidos varchar(50),\r\n" + 
				"Nacionalidad varchar(50),\r\n" + 
				"Telefono integer(50),\r\n" + 
				"Noches integer(100),\r\n" + 
				"CheckIn varchar(50),\r\n" + 
				"CheckOut varchar(50),\r\n" + 
				"Deposito integer(20),\r\n" + 
				"Total_habitaciones integer(10),\r\n" + 
				"PrecioPorNoche integer(10))\r\n" + 
				";";
		
		Connection conn = Connect.getConnection();
		st = conn.createStatement();
		st.executeUpdate(sql);
		
		st.close();
		conn.close();
	}*/
	
	/*public int editPricePerNight(int newPrice){
		
						
		super.client.setPricePerNight(newPrice);
		
		return newPrice; 
			
	}*/
}
