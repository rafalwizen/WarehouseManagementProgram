package wizen.rafal.WMP.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="transport_company")
@Getter
@Setter
@ToString
public class TransportCompany {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="short_name")
	private String shortName;

	@OneToMany(mappedBy="transportCompany")
	@JsonIgnore
	private List<ShippingOrder> shippingOrders;
	
	public TransportCompany() {
		
	}

	public TransportCompany(int id, String name, String shortName) {
		this.id = id;
		this.name = name;
		this.shortName = shortName;
	}
	
}
