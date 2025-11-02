package dev.thoisana.ProductServiceAPI.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	private Long id;
    public void setId(Long id) {
		this.id = id;
	}
	private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;
    
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Long getId() {
		return id;
	}


}
