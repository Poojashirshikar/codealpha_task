import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class StudentGradeTracker
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> grades = new ArrayList<>();
		
		System.out.println("Welcome To The Student Grade Tracker!!");
		System.out.println("Enter grades for students. Type -1 to stop.");
	
		while(true)
		{
			System.out.println("Enter Grade:");
			int grade = sc.nextInt();
			if(grade == -1)
			{
				break;
			}
			
			if(grade < 0 || grade > 100)
			{
				System.out.println("Invalid grade ! Pleaes enter a grade between 0 to 100");
				continue;
			}
			grades.add(grade);
		}
		
	
		if(grades.isEmpty())
		{
			System.out.println("No grades are entered.Existing program.");
			
		}
		else
		{
			
			int sum = 0;
			int highest = Integer.MIN_VALUE;
			int lowest = Integer.MAX_VALUE;
			
			for (int grade:grades)
			{
				sum += grade;
				if(grade>highest)
				{
					highest = grade;
				}
				if( grade<lowest)
				{
					lowest = grade;
				}
			}
			double average = (double)sum/grades.size();
			
		
			System.out.println("\nGrade Summary: ");
			System.out.println("Number of grades:"+grades.size());
			System.out.println("Average Grade"+String.format("%.2f",average));
			System.out.println("Highest grade:"+highest);
			System.out.println("Lowest grade:"+lowest);
		}
		sc.close();
	}
	
}
