import java.util.Scanner;

public class MovieDriver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean again = false;
		
		do {
		
		Movie movie1 = new Movie();
		
		System.out.println("Enter the movie title: ");
		movie1.setTitle(input.nextLine());
		
		System.out.println("Enter " + movie1.getTitle() + "'s movie rating.\n" + 
		"Enter 1 for G\n"     +
		"Enter 2 for PG\n"	  +
		"Enter 3 for PG-13\n" +
		"Enter 4 for R\n"     +
		"Enter 5 for NC-17\n" +
		"Rating --> :");
		
		String ratingResponse = (input.nextLine());
		if(!(ratingResponse.equals("1") || ratingResponse.equals("2") ||
				   ratingResponse.equals("3")|| ratingResponse.equals("4")||
				   ratingResponse.equals("5"))) 
			ratingResponse = "0";
		
		
		boolean badEntry = true;
		int counter = 0;
		while (badEntry == true) {
			
			badEntry = false;
			switch(Integer.parseInt(ratingResponse)) {
				case 1: movie1.setRating("G");
					break;
				case 2:	movie1.setRating("PG");
					break;
				case 3: movie1.setRating("PG-13");
					break;
				case 4: movie1.setRating("R");
					break;
				case 5: movie1.setRating("NC-17");
					break;
	
				default : {badEntry = true;
							counter++;
							System.out.println("Invalid response, must enter a number from 1 - 5: ");
							ratingResponse = input.nextLine();
							if(!(ratingResponse.equals("1") || ratingResponse.equals("2") ||
								 ratingResponse.equals("3")|| ratingResponse.equals("4")||
							     ratingResponse.equals("5"))) 
							ratingResponse = "0";
							}
			if(counter == 5) {
			System.out.println("You have reached the maximum number of invalid entries allowed.\n" +
					   "The program will now exit.\n Goodbye!.");
			System.exit(0);
				}
			
			}
		}
	
		
		System.out.println("Enter the number of tickets sold for " + movie1.getTitle());
		movie1.setSoldTickets(input.nextInt());
		
		System.out.println(movie1.toString());
		input.nextLine();
		System.out.println("Would you like to enter another movie? (y / n): ");
			String response = input.nextLine();
			response.trim();
		
		boolean invalidInput = false;
		for(int i = 5; i > 0;i--)
		{
			
				switch(response) {
				case "y": 
				case "Y":again = true;
				break;
				case "N":
				case "n":again = false;
				break;
				default :invalidInput = true;
			if(invalidInput == false) {
				continue;
				}
			else
				System.out.println("|Invalid entry|\n \"Would you like to enter another movie? (y / n): ");
				response = input.nextLine();
				response.trim();
			}
			
			
		
		}
		//loop has iterated 5 times and user input is still invalid	
		if (invalidInput == true) {
				System.out.println("You have reached the maximum number of invalid entries allowed.\n" +
									   "The program will now exit.\n Goodbye!.");
				System.exit(0);
					}
		
		}while(again == true);
		System.out.println("Have a nice day!");
	}

}
