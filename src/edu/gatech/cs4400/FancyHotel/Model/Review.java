package edu.gatech.cs4400.FancyHotel.Model;

import java.util.ArrayList;
import java.util.List;

public class Review {
	
	private String location;
	private String comment;
	private String rating;
	private String username;
	private int review_no;
	
	public Review(String location, String comment, String rating, String username, int review_no) {
		this.location = location;
		this.comment = comment;
		this.rating = rating;
		this.username = username;
		this.review_no = review_no;
	}
	
	public static List<Review> getReviewsByLocation(String location) {
		ArrayList<Review> reviews = new ArrayList<>();
		reviews.add(new Review("Atlanta", "Nice Place", "Excellent", "lhx", 1203)); 
		reviews.add(new Review("Charlotte", "WTH", "Very Bad", "wenzi", 1111));
		return reviews;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}


}
