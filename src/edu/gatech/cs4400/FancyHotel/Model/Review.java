package edu.gatech.cs4400.FancyHotel.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.gatech.cs4400.FancyHotel.Model.Room.LOCATION;

public class Review {
	
	private Room.LOCATION location;
	private String comment;
	private String username;
	public RATING rating;
	private int reviewNo;
	
	
	public enum RATING { 
        EXCELLENT("Excellent"), GOOD("Good"), BAD("Bad"), VERY_BAD("Very Bad"), NEUTRAL("Neutral"); 
        private String rating; 
        private RATING(String rating) { 
            this.rating = rating; 
        } 
        
        @Override 
        public String toString(){ 
            return rating; 
        } 
    } 	
	
	
	
	public Review(RATING rating, String comment) {
		this.comment = comment;
		this.rating = rating;
	}
	
	public static int generateReviewNo(){
		String sql = "SELECT MAX(ReviewNo) AS MAX FROM HOTEL_REVIEW";
		JSONArray jArray = DatabaseConnector.query(sql);
		try {
			JSONObject obj = jArray.getJSONObject(0);
			int currentMaxNo = obj.getInt("MAX");
			return currentMaxNo+1;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}
	
	//TODO: implement
	public static List<Review> getReviewsByLocation(Room.LOCATION location) {
		String sql = String.format("SELECT Rating, Comment FROM HOTEL_REVIEW " +
									"WHERE Location='%s' ",
									location.toString());
		System.out.println(sql);
		JSONArray reviews = DatabaseConnector.query(sql);
		ArrayList<Review> returnReviews = new ArrayList<Review>();
		try {
			for(int i=0;i<reviews.length();i++){
				JSONObject curReview = reviews.getJSONObject(i);
				Review newReview = new Review(Review.RATING.valueOf(curReview.getString("Rating").toUpperCase().trim()),
						curReview.getString("Comment"));
				returnReviews.add(newReview);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnReviews;
	}
	
	public static void CreateReview(int reviewNo, Room.LOCATION location, String rating, String comment, String username) {
		String sql =
				"INSERT INTO HOTEL_REVIEW (ReviewNo, Rating, Location, Comment, Username)"+
				"Values('"+reviewNo+"', '"+rating+"', '"+location+"', '"+comment+"', '"+username+"')";
		DatabaseConnector.update(sql);
	}
	
	public LOCATION getLocation() {
		return location;
	}

	public void setLocation(LOCATION location) {
		this.location = location;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public RATING getRating() {
		return rating;
	}

	public void setRating(RATING rating) {
		this.rating = rating;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


}
