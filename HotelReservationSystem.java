import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

class Room
{
	private int roomNumber;
	private String category;
	private double price;
	private boolean isAvailable;
	
	public Room(int roomNumber, String category, double price)
	{
		this.roomNumber = roomNumber;
		this.category = category;
		this.price  = price;
		this.isAvailable = true;//All room start as available
	}
	
	public int getRoomNumber()
	{
		return roomNumber;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public boolean isAvailable()
	{
		return isAvailable;
	}
	
	public void reserve()
	{
		isAvailable = false;
	}
	
	public void cancelReservation()
	{
		isAvailable = true;
	}
}

class Reservation
{
	private Room room;
	private String guestName;
	private double totalAmount;
	
	public Reservation(Room room, String guestName)
	{
		this.room = room;
		this.guestName = guestName;
		this.totalAmount = room.getPrice();
		room.reserve();
	}
	
	public Room getRoom()
	{
		return room;
	}
	
	public String getguestName()
	{
		return guestName;
	}
	
	public double getTotalAmount()
	{
		return totalAmount;
	}
}

public class HotelReservationSystem
{
	private static ArrayList<Room> rooms = new ArrayList<>();
	private	static ArrayList<Reservation> reservations = new ArrayList<>();
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		initializeRoom();
		
		while(true)
		{
			System.out.println("\n--- Hotel Reservation System ---");
			System.out.println("1. View Available Rooms");
			System.out.println("2. Make a Reservation");
			System.out.println("3. View BOoking Details");
			System.out.println("4. Exit");
			System.out.println("Choose an option:");
			
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					viewAvailableRooms();
					break;
				case 2:
					makeReservation(sc);
					break;
				case 3:
					viewBookingDetails(sc);
					break;
				case 4:
					System.out.println("Thank You For Using Hotel Reservation System!! GoodBye!!");
					sc.close();
					return;
				default:
					System.out.println("Invalid choice. Please try again.");
					
					
			}
		}
	}
	
	private static void initializeRoom()
	{
		rooms.add(new Room( 101 , "Single" , 100.0));
		rooms.add(new Room( 102 , "Double" , 150.0));
		rooms.add(new Room( 103 , "Suite" , 300.0));
		rooms.add(new Room( 104 , "Single" , 100.0));
		rooms.add(new Room( 105 , "Double" , 150.0));
	}
	
	private static void viewAvailableRooms()
	{
		System.out.println("\nAvailable Rooms:");
		for(Room room:rooms)
		{
			if(room.isAvailable())
			{
				System.out.println("Room" + room.getRoomNumber() + " (" + room.getCategory() + " ) - $ " + room.getPrice());
			}
		}
		
	}
	private static void makeReservation(Scanner sc)
	{
		System.out.println("\nEnter your name:");
		sc.nextLine();//consume new line
		String guestName = sc.nextLine();
		System.out.println("Enter room number to reserve:");
		int roomNumber = sc.nextInt();
		
		Room selectedRoom = null;
		for(Room room:rooms)
		{
			if(room.getRoomNumber() == roomNumber && room.isAvailable())
			{
				selectedRoom = room;
				break;
			}
		}
		if(selectedRoom != null)
		{
			Reservation reservation = new Reservation(selectedRoom, guestName);
			reservations.add(reservation);
			
			System.out.println("Reservation successfull for room " + roomNumber + "under the name" + guestName + ".");
			System.out.println("Total Amount: $" + selectedRoom.getPrice());
		}
		else
		{
			System.out.println("Room is not available or does not exits.");
			
		}
		
	}
	private static void viewBookingDetails(Scanner sc)
	{
		System.out.println("\n Enter your name to view booking details:");
		sc.nextLine();
		String guestName = sc.nextLine();
		
		boolean found = false;
		for(Reservation reservation : reservations)
		{
			if(reservation.getguestName().equalsIgnoreCase(guestName))
			{
				System.out.println("\n Booking Details:");
				System.out.println("Name" + reservation.getguestName());
				System.out.println("Room number:" +reservation.getRoom().getRoomNumber());
				System.out.println("Room Category: " + reservation.getRoom().getCategory());
				System.out.println("Total Amount : $" + reservation.getTotalAmount());
				found = true;
				break;
			}
		}
		
		if(!found)
		{
			System.out.println("No reservation found for the name" + guestName+".");
		}
	}
}
