package com.reservationbb.pob.model;

import java.time.LocalDate;

public class Management {

	// ATRIBUTOS
	private static final int MAX_PER_ROOM = 2;
	private int totalRooms;
	private int totalNights;
	private double pricePerNight = 61.5; // Debo crear un Botón en el index.jsp para poder modificar el precio cuando queramos
	private double amountPending;
	private double total = (pricePerNight * totalNights) - amountPending;
	private double deposit;
	// Date reservationStart;
	LocalDate checkIn;

	// Date reservationEnd;
	LocalDate checkOut;

	public Management(LocalDate checkIn, LocalDate checkOut, int totalRooms, double deposit) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.totalRooms = totalRooms;
		this.deposit = deposit;
	}
	
	public Management() {
		
	}
	// Date reservationDate = new Date();
	// LocalTime checkInTime;
	// LocalTime lateCheckOut;

	// SETTERS Y GETTERS
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

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public double getAmountPending() {
		return amountPending;
	}

	public void setAmountPending(double amountPending) {
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
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

	/*
	 * public Date getReservationDate() { return reservationDate; } public void
	 * setReservationDate(Date reservationDate) { this.reservationDate =
	 * reservationDate; }
	 * 
	 * public LocalTime getCheckInTime() { return checkInTime; } public void
	 * setCheckInTime(LocalTime checkInTime) { this.checkInTime = checkInTime; }
	 * public LocalTime getLateCheckOut() { return lateCheckOut; } public void
	 * setLateCheckOut(LocalTime lateCheckOut) { this.lateCheckOut = lateCheckOut; }
	 * public Date getReservationStart() { return reservationStart; } public void
	 * setReservationStart(Date reservationStart) { this.reservationStart =
	 * reservationStart; } public Date getReservationEnd() { return reservationEnd;
	 * } public void setReservationEnd(Date reservationEnd) { this.reservationEnd =
	 * reservationEnd; }
	 */
}
