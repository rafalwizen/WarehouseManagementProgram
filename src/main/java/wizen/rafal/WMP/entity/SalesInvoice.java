package wizen.rafal.WMP.entity;

import java.util.Date;

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
	
	public SalesInvoice() {
		
	}

	public SalesInvoice(int id, Date dateOfIssue) {
		this.id = id;
		this.dateOfIssue = dateOfIssue;
	}
}
