package com.reservationbb.pob.model;


public class Client {

	// ATRIBUTOS
	
	private int id = 1;
	private String name;
	private String surname;
	private String nationality;
	private int telephone;
	// private static AtomicInteger ID_GENERATOR = new AtomicInteger(100);

	
	// Constructor de cliente
	
	public Client(int id, String name, String surname, String nationality, int telephone ) {
		this.name=name;
		this.surname=surname;
		this.nationality = nationality;
		this.telephone = telephone;
		this.id = id;

	}
	public Client() {
	}

	// SETTERS Y GETTERS
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = ++id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

}
