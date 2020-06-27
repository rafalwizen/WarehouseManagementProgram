package wizen.rafal.WMP.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="purchase_invoice")
@Getter
@Setter
@ToString
public class PurchaseInvoice {

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
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="transfer_id")
	private Transfer transfer;
	
	@OneToMany(mappedBy="purchaseInvoice")
	private List<PurchaseOrder> purchaseOrders;
	
	public PurchaseInvoice() {
		
	}

	public PurchaseInvoice(int id, Date dateOfIssue) {
		this.id = id;
		this.dateOfIssue = dateOfIssue;
	}
	
}
