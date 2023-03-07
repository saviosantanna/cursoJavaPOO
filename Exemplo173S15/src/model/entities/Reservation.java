package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reservation() {
	}

	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRommNumber() {
		return roomNumber;
	}

	public void setRommNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long t1 = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay()).toDays();
		return t1;
	}

	public String updateDates(LocalDate checkIn, LocalDate checkOut) {
		LocalDate now = LocalDate.now();
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			return "Reservation dates for update must be future dates";
		}
		if (!checkOut.isAfter(checkIn)) {
			return "Check-out date must be after check-in date";
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return toString();
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in " + checkIn.format(fmt) + ", check-out " + checkOut.format(fmt) + ", "
				+ duration() + " nights";
	}
}