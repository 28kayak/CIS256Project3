import java.util.Scanner;
public class MainSuperClass
{


	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		SuperList firstList = new SuperList();
		SuperList secondList = new SuperList();
		int action;
		int list;
		String name;
		System.out.println("You have TWO lists to store customer's name!");
		System.out.println("");
		
		System.out.println("Choose an action you want to excute");
		System.out.println("1: Add a customer into the end of the list");
		System.out.println("2: Add a Priority customer into the list");
		System.out.println("3: Remove the first customer from the list");
		System.out.println("4: Remove a specific customer form the list");
		System.out.println("5: Remove first some numbers of customer from the list");
		System.out.println("6: Print out the name of the first customer");
		System.out.println("7: Print out particular customer");
		System.out.println("8: Check if the list is empty or not");
		System.out.println("9: Check how many customers on the list");
		System.out.println("10: Check if two lists are identical"); 
		
		action = scan.nextInt();
		switch (action)
		{
			case 1:
				System.out.println("Which list do you want to add? type 1 into fisrst list, 2 into second list");
				list = scan.nextInt();
				System.out.println("Entry customer's name");
				name = scan.nextLine();
				
				if(list == 1)
				{
					firstList.insertRear(name);
				}
				else if(list == 2)
				{
					secondList.insertRear(name);
				}
			case 2:
				System.out.println("Which list do you want to add? type 1 into fisrst list, 2 into second list");
				list = scan.nextInt();
				System.out.println("Entry your priorty customer's name");
				name = scan.nextLine();
				if(list == 1)
				{
					firstList.insertFront(name);
				}
				else if(list == 2)
				{
					secondList.insertFront(name);
				}
			case 3:
				
				
		
		
		}
		

	}

}
