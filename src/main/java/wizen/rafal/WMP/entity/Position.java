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
@Table(name="position")
@Getter
@Setter
@ToString
public class Position {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="short_name")
	private String shortName;
	
	@Column(name="has_billing_option")
	private boolean hasBillingOption;
	
	public Position() {
		
	}

	public Position(int id, String name, String shortName, boolean hasBillingOption) {
		this.id = id;
		this.name = name;
		this.shortName = shortName;
		this.hasBillingOption = hasBillingOption;
	}
}
