package wizen.rafal.WMP.entity;

import java.util.Date;

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
@Table(name="shipping_order")
@Getter
@Setter
@ToString
public class ShippingOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date_of_issue")
	private Date dateOfIssue;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="transport_company_id")
	private TransportCompany transportCompany;
	
	public ShippingOrder() {
		
	}

	public ShippingOrder(int id, Date dateOfIssue) {
		this.id = id;
		this.dateOfIssue = dateOfIssue;
	}
}
