package wizen.rafal.WMP.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="transfer")
@Getter
@Setter
@ToString
public class Transfer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="is_payed")
	private boolean isPayed;

	@Column(name="date_of_issue")
	private Date dateOfIssue;

	@Column(name="amount")
	private float amount;
	
	@OneToOne(mappedBy="transfer")
	@JsonIgnore
	private PurchaseInvoice purchaseInvoice;
	
	@OneToOne(mappedBy="transfer")
	@JsonIgnore
	private SalesInvoice salesInvoice;
	
	public Transfer () {
		
	}

	public Transfer(int id, boolean isPayed, Date dateOfIssue, float amount) {
		this.id = id;
		this.isPayed = isPayed;
		this.dateOfIssue = dateOfIssue;
		this.amount = amount;
	}
	
}
