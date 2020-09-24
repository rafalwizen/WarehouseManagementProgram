package wizen.rafal.WMP.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="part_number")
	private String partNumber;
	
	@Column(name="description")
	private String description;
	
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
	
	@Column(name="belongs_to_cumstoms_warehouse")
	private boolean belongsToCumstomsWarehouse;
	
	@Column(name="is_damaged")
	private boolean isDamaged;
	
	@Column(name="is_teritorialy_restricted")
	private boolean isTeritorialyRestricted;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="manufacturer_id")
	private Manufacturer manufacturer;

	public Item() {
		
	}

	public Item(int id, String partNumber, String description, int weight, char area, int bookstand, int shelf, int availability,
			boolean belongsToCumstomsWarehouse, boolean isDamaged, boolean isTeritorialyRestricted) {
		this.id = id;
		this.partNumber = partNumber;
		this.description = description;
		this.weight = weight;
		this.area = area;
		this.bookstand = bookstand;
		this.shelf = shelf;
		this.availability = availability;
		this.belongsToCumstomsWarehouse = belongsToCumstomsWarehouse;
		this.isDamaged = isDamaged;
		this.isTeritorialyRestricted = isTeritorialyRestricted;
	}
	
}
