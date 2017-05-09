/**
 * The VideoGame class stores data about a video game
 * as well as calculate trade-in value of the game. 
 */
package com.eclipse.haovanhuynh;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
/**
 * 
 * @author Hao Van Huynh
 *
 */
public class VideoGame {
	
	//Fields
	private String title,platform,date;
	private double rating,price;
	
	/**
	 * This no-arg constructor initializes
	 * the variables title, platform, date, rating, price with null values.
	 */
	public VideoGame(){
		title="";
		platform="";
		date="";
		rating =0;
		price=0;
	}
	
	/**
	 * This constructor initializes the variables as params.
	 * @param title		Title of video game
	 * @param platform 	Platform for video game
	 * @param date 		Release date of video game
	 * @param rating 	Rating for video game
	 * @param price		Price of video game
	 */
	public VideoGame(String title,String platform,String date,double rating, double price){
		this.title=title;
		this.platform=platform;
		this.date=date;
		this.rating=rating;
		this.price=price;
	}
	
	/**
	 * @return Returns the title of the video game.
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * @return Returns the platform for the video game.
	 */
	public String getPlatForm(){
		return platform;
	}
	
	/**
	 * @return Returns the release date of the video game.
	 */
	public String getDate(){
		return date;
	}
	
	/**
	 * @return Returns the rating for the video game.
	 */
	public double getRating(){
		return rating;
	}
	
	/**
	 * @return Returns the price of the video game.
	 */
	public double getPrice(){
		return price;
	}
	
	/**
	 * @param newTitle Sets the title of the video game.
	 */
	public void setTitle(String newtitle){
		title=newtitle;
	}
	
	/**
	 * @param newplatform Sets the platform for the video game.
	 */
	public void setPlatForm(String newplatform){
		platform=newplatform;
	}
	
	/**
	 * @param newdate Sets the release date of the video game.
	 */
	public void setDate(String newdate){
		date=newdate;
	}
	
	/**
	 *
	 * @param newrating Sets the rating for the video game.
	 */
	public void setRating(double newrating){
		rating= newrating;
	}
	
	/**
	 * @param newprice Sets the price of the video game.
	 */
	public void setPrice(double newprice){
		price=newprice;
	}
	
	/**
	 * 
	 * @return Returns the trade-in value of the video game.
	 */
	public double TradeInValue(){
		//Get current date for today variable
		LocalDate today = LocalDate.now();
		//Format the date style
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		//Parse the date style
		LocalDate date1 = LocalDate.parse(date,formatter); 
		//Subtract the date1 from the current date
		long days = ChronoUnit.DAYS.between(date1,today);	
		//Calculate trade-in value
		double value=price*Math.pow(1-0.1, days/60); 	
		//If rating >=8.5, $5 will be added to the trade-in value
		if (rating>=8.5)	
			value+=5;
		
		return value;
	}
	
	/**
	 * 
	 * @param array	Array which has double values.
	 * @return Returns total value of the array.
	 */
	public static double TotalValue(ArrayList<Double> array){
		double total=0;
		
		for (int i=0;i<array.size();i++){
			total+=array.get(i);
		}
		return total;
	}
}
