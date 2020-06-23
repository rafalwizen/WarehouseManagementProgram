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
@Table(name="customer")
@Getter
@Setter
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	@Column(name="tax_number")
	private String taxNumber;

	@Column(name="address")
	private String address;

	@Column(name="city")
	private String city;

	@Column(name="postal_code")
	private String postalCode;

	@Column(name="email")
	private String email;
	
	public Customer() {
		
	}

	public Customer(int id, String name, String taxNumber, String address, String city, String postalCode,
			String email) {
		this.id = id;
		this.name = name;
		this.taxNumber = taxNumber;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.email = email;
	}
	
	
}
