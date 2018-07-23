package com.reservationbb.pob.model;



public class Management {
	
	// ATRIBUTOS
	private static final int MAX_PER_ROOM =  2;
	private int numberOfRooms;
	private int totalNights;
	private double pricePerNight = 61.5;
	private double amountPending;
	private double total = (pricePerNight * totalNights) - amountPending ;
	private double deposit;

//	Date reservationStart;
	
//	Date reservationEnd;
	
	
	
//	Date reservationDate = new Date();
//	LocalTime checkInTime;
// 	LocalTime lateCheckOut;
	


	// SETTERS Y GETTERS
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
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
	/*public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	public LocalTime getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(LocalTime checkInTime) {
		this.checkInTime = checkInTime;
	}
	public LocalTime getLateCheckOut() {
		return lateCheckOut;
	}
	public void setLateCheckOut(LocalTime lateCheckOut) {
		this.lateCheckOut = lateCheckOut;
	}
	public Date getReservationStart() {
		return reservationStart;
	}
	public void setReservationStart(Date reservationStart) {
		this.reservationStart = reservationStart;
	}
	public Date getReservationEnd() {
		return reservationEnd;
	}
	public void setReservationEnd(Date reservationEnd) {
		this.reservationEnd = reservationEnd;
	}*/
}
