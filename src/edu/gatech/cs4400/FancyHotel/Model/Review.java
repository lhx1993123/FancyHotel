package edu.gatech.cs4400.FancyHotel.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Review {
	
	public enum LOCATION{ATLANTA, CHARLOTTE, SAVANNAH, ORLANDO, MIAMI};
	private Review.LOCATION location;
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
	
	//TODO: implement
	public static List<Review> getReviewsByLocation(Review.LOCATION location) {
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
