package Exemplos_aulas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

//import model.entities.Reservation;

public class Exemplo173S15 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Roomnumber: ");
			int roomNumber = sc.nextInt();
			sc.nextLine();
			System.out.print("Check in: ");
			String dataCheckIn = sc.nextLine();
			LocalDate checkIn = LocalDate.parse(dataCheckIn, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Check Out: ");
			String dataCheckOut = sc.nextLine();
			LocalDate checkOut = LocalDate.parse(dataCheckOut, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	
			Reservation reserv = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation " + reserv);
	
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check in: ");
			dataCheckIn = sc.nextLine();
			checkIn = LocalDate.parse(dataCheckIn, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Check Out: ");
			dataCheckOut = sc.nextLine();
			checkOut = LocalDate.parse(dataCheckOut, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	
			reserv.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reserv);
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: "+ e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();

	}

}