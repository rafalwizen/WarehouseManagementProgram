package wizen.rafal.WMP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="branch")
@Getter
@Setter
@ToString
public class Branch {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="short_name")
	private String shortName;
	
	@Column(name="address")
	private String address;

	@Column(name="city")
	private String city;

	@Column(name="postal_code")
	private String postalCode;
	
	public Branch() {
		
	}

	public Branch(int id, String name, String shortName, String address, String city, String postalCode) {
		this.id = id;
		this.name = name;
		this.shortName = shortName;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
	}
}
