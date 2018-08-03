package com.reservationbb.pob.model;

import java.util.Date;

import com.reservationbb.pob.dao.ClientDao;
import com.reservationbb.pob.dao.ManagementDao;

import java.time.LocalDate;

public class Client {
	
	// ATRIBUTOS
	private int id;
	private String name;
	private String surname;
	private String nationality;
	private int telephone;

	// Estos atributos son los que estaban en la clase management
	private static final int MAX_PER_ROOM = 2;
	private int totalRooms;

	private int totalNights;// Tiene que ser = a la diferencia entre el check in y el check out
	public int pricePerNight = 65; // Debo crear un Botón en el index.jsp para poder modificar el precio cuando
									// queramos

	private double amountPending;
	private double total = (pricePerNight * totalNights) - amountPending;
	private int deposit;
	// Date reservationStart;
	private LocalDate checkIn;
	// Date reservationEnd;
	private LocalDate checkOut;

	public Client(String name, String surname, String nationality, int telephone, int totalNights, LocalDate checkIn,
					LocalDate checkOut, int deposit, int totalRooms) {
		this.name = name;
		this.surname = surname;
		this.nationality = nationality;
		this.telephone = telephone;
		this.totalNights = totalNights;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.deposit = deposit;
		this.totalRooms = totalRooms;
	}
	

	// Constructor con el campo id
	public Client(int id, String name, String surname, String nationality, int telephone, int totalNights,
			LocalDate checkIn, LocalDate checkOut, int deposit, int totalRooms, int pricePerNight) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.nationality = nationality;
		this.telephone = telephone;
		this.totalNights = totalNights;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.deposit = deposit;
		this.totalRooms = totalRooms;
		this.pricePerNight = pricePerNight;
	}

	public Client() {
		// TODO Auto-generated constructor stub
	}


	// SETTERS Y GETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}

	public int getTotalNights() {
		return totalNights;
	}

	public void setTotalNights(int totalNights) {
		this.totalNights = totalNights;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public int getPricePerNight() {
		return pricePerNight;
	}
	
	public void  setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public void setAmountPending(double amountPending) {
		this.amountPending = amountPending;
	}

	public void setTotal(double total) {
		this.total = total;
	}



}
