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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="sales_invoice")
@Getter
@Setter
@ToString
public class SalesInvoice {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date_of_issue")
	private Date dateOfIssue;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
 						CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="shipping_order_id")
	private ShippingOrder shippingOrder;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="transfer_id")
	private Transfer transfer;
	
	public SalesInvoice() {
		
	}

	public SalesInvoice(int id, Date dateOfIssue) {
		this.id = id;
		this.dateOfIssue = dateOfIssue;
	}
}
