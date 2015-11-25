package edu.gatech.cs4400.FancyHotel.Model;

import java.util.ArrayList;
import java.util.List;

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
	
	
	
	public Review(Room.LOCATION location, String comment, RATING rating, String username, int reviewNo) {
		this.location = location;
		this.comment = comment;
		this.rating = rating;
		this.username = username;
		this.reviewNo = reviewNo;
	}
	
	//TODO: implement
	public static List<Review> getReviewsByLocation(String location) {
		ArrayList<Review> reviews = new ArrayList<>();
		reviews.add(new Review(Room.LOCATION.ATLANTA, "Nice Place", RATING.EXCELLENT, "lhx", 1203)); 
		reviews.add(new Review(Room.LOCATION.CHARLOTTE, "WTH", RATING.VERY_BAD, "wenzi", 1111));
		return reviews;
	}

	public Room.LOCATION getLocation() {
		return location;
	}

	public void setLocation(Room.LOCATION location) {
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
