/**
 * This class is to demonstrate how VideoGame class works.
 */
package com.eclipse.haovanhuynh;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class VideoGameDemo {
	
	public static void main(String[] args){
		
		System.out.println("Welcome! Thank you for using this program.");
		System.out.println("This program is programmed to store video game data as well as help calculate their trade-in value");
		System.out.println("Here are some sample outputs of this program below.");
		System.out.println("");

		ArrayList<Double> array = new ArrayList<Double>();
		
		//Create the first video game, uses no-arg constructor
		VideoGame game1 = new VideoGame();
		
		//Set the values for the new video game.
		game1.setTitle("Resident Evil 7 Biohazard");
		game1.setPlatForm("PS4");
		game1.setDate("January 24, 2017");
		game1.setRating(8.2);
		game1.setPrice(59.99);
		
		//Display the data for game 1.
		System.out.println("Title: "+game1.getTitle());
		System.out.println("Platform: "+game1.getPlatForm());
		System.out.println("Release Date: "+game1.getDate());
		System.out.println("Rating: "+game1.getRating());
		System.out.println("Price: "+game1.getPrice());
		
		//Calculate and display trade-in value of game 1.
		double v1=game1.TradeInValue();
		System.out.printf("Current Trade-In Value: %.2f \n",v1); //Format double value to 2 decimal places
		
		//Add the trade-in value v1 to the ArrayList array.
		array.add(v1);	 
		
		//Display the total trade-in value of all games.
		System.out.printf("Total Trade-In Value for All Games: %.2f",VideoGame.TotalValue(array));
		System.out.println("\n");
		
		//Create the second video game, uses constructor that accepts all params.
		VideoGame game2 = new VideoGame("Pokemon Apha Sapphire", "Nintendo 3DS","November 21, 2014",9.6,39.99);
		
		//Display the data from the params for game 2.
		System.out.println("Title: "+game2.getTitle());
		System.out.println("Platform: "+game2.getPlatForm());
		System.out.println("Release Date: "+game2.getDate());
		System.out.println("Rating: "+game2.getRating());
		System.out.println("Price: "+game2.getPrice());
		
		//Calculate and display trade-in value of game 2.
		double v2=game2.TradeInValue();
		System.out.printf("Current Trade-In Value: %.2f \n",v2);
		
		//Add the trade-in value v2 to the ArrayList array.
		array.add(v2);
		
		//Display the total trade-in value of all games.
		System.out.printf("Total Trade-In Value for All Games: %.2f",VideoGame.TotalValue(array));
		System.out.println("\n");
		
		//Create the third video game, uses constructor that accepts all params.
		VideoGame game3 = new VideoGame("The Last of Us Remastered", "PS4","March 21, 2017",9.4,19.99);
		
		//Display the data from the params for game 2.
		System.out.println("Title: "+game3.getTitle());
		System.out.println("Platform: "+game3.getPlatForm());
		System.out.println("Release Date: "+game3.getDate());
		System.out.println("Rating: "+game3.getRating());
		System.out.println("Price: "+game3.getPrice());
		
		//Calculate and display trade-in value of game 3.
		double v3=game3.TradeInValue();
		System.out.printf("Current Trade-In Value: %.2f \n",v3);
		
		//Add the trade-in value v3 to the ArrayList array.		
		array.add(v3);
		
		//Display the total trade-in value of all games.
		System.out.printf("Total Trade-In Value for All Games: %.2f",VideoGame.TotalValue(array));
		System.out.println("\n");
		
		//Create Scanner object for scan input.
		Scanner scan=new Scanner (System.in);
		
		//Prompt user to enter their game information.
		//Ask them if they want to use this program.
		System.out.print("OK, now you can freely try this program.\nDo you want to try? (Y or N)");
		String test=scan.nextLine();
		
		//If they don't answer YES...
		if (test.charAt(0)!='Y'&&test.charAt(0)!='y'){
			//Say goodbye to them.
			System.out.println("Thank you for using this program. GOOD BYE!");
			scan.close();
			return; //Quit this program.
		}
		
		//Or Welcome them.
		System.out.println("Please enter your game information below.");
		String input; //String local variable for the loop below.
		
		//Make a do-while loop for user to enter their game information over and over
		//until they say NO.
		do{
			//Input title of video game
			System.out.print("Title: ");
			String title=scan.nextLine();
			
			//Input platform of video game
			System.out.print("Platform: ");
			String platform=scan.nextLine();
			
			//Input release date of video game
			System.out.print("Release Date (MMMM dd, yyyy): ");
			String date=scan.nextLine();
			
			//Make a loop if the date format is not MMMM dd, yyyy.
			while(isValidDate(date)==false){
				System.out.println("Invalid date. Please type again.");
				System.out.print("Release Date (MMMM dd, yyyy): ");
				date=scan.nextLine();
			};
			
			//Input rating of video game
			double rating=0;
			//Make a loop to check if the input is not a String
			for(int i=0;i<Double.POSITIVE_INFINITY;i++){
				try{
					System.out.print("Rating: ");
					rating=scan.nextDouble();
				}
				
				catch(InputMismatchException d){
					System.out.println("Invalid number. Please type again.");
					scan.nextLine();
					continue;	//skip and continue to the next loop
				}
				break;	//go outside of the loop
			}
			
			//Input price of video game
			double price=0;
			
			//Make a loop to check if the input is not a String
			for (int i=0;i<Double.POSITIVE_INFINITY;i++){
				try{
					System.out.print("Price: ");
					price=scan.nextDouble();
				}
				
				catch(InputMismatchException d){
					System.out.println("Invalid number. Please type again.");
					scan.nextLine();
					continue;	//skip and continue to the next loop
				}
				break; //go outside of the loop
			}
			
			//Create the game of user, using all data of their game as params.
			VideoGame random = new VideoGame(title,platform,date,rating,price);
			
			//Display all game information of the user.
			System.out.println("\nYour game information");
			System.out.println("Title: "+random.getTitle());
			System.out.println("Platform: "+random.getPlatForm());
			System.out.println("Release Date: "+random.getDate());
			System.out.println("Rating: "+random.getRating());
			System.out.println("Price: "+random.getPrice());
			
			//Calculate and display the trade-in value.
			double v=random.TradeInValue();
			System.out.printf("Current Trade-In Value: %.2f \n",v);
			
			//Add the trade-in value to the ArrayList array.
			array.add(v);
			
			//Display the total trade-in value of all games.
			System.out.printf("Total Trade-In Value for All Games: %.2f",VideoGame.TotalValue(array));
			System.out.println("\n");
			
			scan.nextLine(); //Consume the newline left-over
			
			System.out.print("Try again? (Y or N) "); //Ask them.
			input=scan.nextLine();
			
		} while(input.charAt(0)=='Y'||input.charAt(0)=='y');
		
		//Say goodbye.
		System.out.println("Thank you for using this program. GOOD BYE!");
		scan.close(); //Close Scanner class.
	}
	
	//The isValidDate method is to check if the format date is acceptable.
	public static boolean isValidDate(String date) {
	    SimpleDateFormat format = new SimpleDateFormat("MMMM dd, yyyy"); //Set format date
	    
	    try {
	        format.parse(date);
	        return true;
	        
	    } catch (ParseException e) {
	        return false;
	    }
	}
}
