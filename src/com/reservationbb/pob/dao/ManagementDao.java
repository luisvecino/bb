package com.reservationbb.pob.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.reservationbb.pob.service.Connect;

public class ManagementDao extends ClientDao {
	
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
    
	/*public int editPricePerNight(int newPrice){
		
						
		super.client.setPricePerNight(newPrice);
		
		return newPrice; 
			
	}*/
}
