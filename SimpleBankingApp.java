import java.util.Scanner;
public class SimpleBankingApp 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		double balance = 0.0;
		boolean exit = false;
		
		System.out.println("Welcome to Simple Banking Application!");
		
		while (!exit)
			{
			System.out.println("Please select an option:");
			System.out.println("1. Deposit");
			
			System.out.println("2. Withdraw");
			System.out.println("3. Check balance");
			System.out.println("4. Exit");
			System.out.println("Enter you choice");
			
			int choice = sc.nextInt();
			
			switch (choice) 
			{
				case 1:
					System.out.println("Enter the deposite amount: ");
					double depositAmount = sc.nextDouble();
					
					if (depositAmount > 0) 
					{
						balance += depositAmount;
						System.out.println("Successfully deposited  $ :" + depositAmount);
		
					}
					else
					{
						System.out.println("Invalid amount.Please enter a positive value.");

					}
					
					break;
					
					case 2:
						System.out.println("Enter the withdrawal amount :");
						double withdrawalAmount = sc.nextDouble ();
						if ( withdrawalAmount > 0 && withdrawalAmount <= balance )
						{
							balance -= withdrawalAmount;
							System.out.println("Successfully withdraw $" + withdrawalAmount);
							
						}
						else if ( withdrawalAmount > balance )
						{
							System.out.println("Insufficient balance!");
						}
						else 
						{
							System.out.println("Invalid amount.Please enter positive value");
							
						}
						break;
						
						case 3:
							System.out.println("Your current balance is $: " + balance);
							break;
							
						case 4:
							exit = true;
							System.out.println("Thank you for using the Simple Banking Application. Good Bye ! ");
							break;
							
							default:
							System.out.println("Invalid choice. Please try  Again.");
			}
	
	}
	sc.close();
}

}