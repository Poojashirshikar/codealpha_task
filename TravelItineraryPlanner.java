import java.util.*;

public class TravelItineraryPlanner 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner (System.in);
		
	
		System.out.println("Welcome To The Treavel Itinerary Planner!!");
		
		System.out.println("Enter your name:");
		String name = sc.nextLine();
		
		System.out.println("Enter your Destination");
		String destination = sc.nextLine();
		
		System.out.println("Enter your travel start date (yyyy-mm-dd):");
		String startDate = sc.nextLine();
		
		System.out.println("Enter your travel end date (yyyy-mm-dd) :");
		String endDate = sc.nextLine();
		
		System.out.println("Enter your budget (in USD): ");
		double budget = sc.nextDouble
		();
		
		sc.nextLine();
		
		System.out.println("Do you want to include weather information?? (Yes/No) : ");
		String includeWeather = sc.nextLine().toLowerCase();
		
		//Display Itinerary
		System.out.println("\n--- Travel Itinerary ---");
		System.out.println("Name: "+name);
		System.out.println("Destination: "+destination);
		System.out.println("Travel Dates: "+startDate+"to"+endDate);
		System.out.println("Budget: $"+budget);
		
		if(includeWeather.equals("yes"))
		{
			displayWeatherInfo(destination);
		}
	
		System.out.println("Your Travel itinerary has been successfully created!!");
		
	}
	private static void displayWeatherInfo(String destination)
	{
		
		
		System.out.println("\n---Weather Information for"+destination+"---");
		System.out.println("Average Temperature:25 C");
		System.out.println("Condition: Sunny");
		
	}
}