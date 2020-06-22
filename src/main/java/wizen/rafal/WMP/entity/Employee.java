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
@Table(name="employee")
@Getter
@Setter
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;

	@Column(name="personal_identity_number")
	private int personalIdentityNumber;

	@Column(name="address")
	private String address;

	@Column(name="city")
	private String city;

	@Column(name="postal_code")
	private String postalCode;

	@Column(name="email")
	private String email;

	private String position_id;

	private String branch_id;
	
	public Employee() {
		
	}

	public Employee(int id, String firstName, String lastName, int personalIdentityNumber, String address, String city,
			String postalCode, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.personalIdentityNumber = personalIdentityNumber;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.email = email;
	}
	
	
}
