package edu.gatech.cs4400.FancyHotel.Model;

import java.util.ArrayList;
import java.util.List;

public class Review {
	
	private String location;
	private String review;
	
	public Review(String location, String review) {
		this.location = location;
		this.review = review;
	}
	
	public static List<Review> getReviewsByLocation(String location) {
		ArrayList<Review> reviews = new ArrayList<>();
		reviews.add(new Review()) 
		ret
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
}
