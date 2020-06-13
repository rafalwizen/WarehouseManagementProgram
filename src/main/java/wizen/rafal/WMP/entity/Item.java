package wizen.rafal.WMP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="weight")
	private int weight;
	
	@Column(name="area")
	private char area;
	
	@Column(name="bookstand")
	private int bookstand;
	
	@Column(name="shelf")
	private int shelf;
	
	@Column(name="availability")
	private int availability;
	
	@Column(name="manufacturer_id")
	private int manufacturerId;
	
	@Column(name="item_type_id")
	private int itemTypeId;

	public Item(String name, int weight, char area, int bookstand, int shelf, int availability) {
		this.name = name;
		this.weight = weight;
		this.area = area;
		this.bookstand = bookstand;
		this.shelf = shelf;
		this.availability = availability;
	}

	
}
