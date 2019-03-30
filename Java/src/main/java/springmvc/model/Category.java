package springmvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name", length = 100)
	private String name;
	
	@Column(name="description", columnDefinition = "TEXT")
	private String description;
	
	@Column(name="image")
	private String image;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	private List<Product> listProduct = new ArrayList<Product>();

	public Category() {
		super();
	}

	public Category(int id, String name, String description, String image, List<Product> listProduct) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.listProduct = listProduct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}
	
	
}
