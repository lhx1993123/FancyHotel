package edu.gatech.cs4400.FancyHotel.Model;

import java.util.ArrayList;
import java.util.List;

public class Review {
	
	private String location;
	private String comment;
	private 
	
	public Review(String location, String comment) {
		this.location = location;
		this.comment = comment;
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


}
