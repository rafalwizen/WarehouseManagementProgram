package wizen.rafal.WMP.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="sales_order")
@Getter
@Setter
@ToString
public class SalesOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="sales_invoice_id")
	@JsonIgnore
	private SalesInvoice salesInvoice;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="item_id")
	private Item item;
	
	public SalesOrder() {
		
	}

	public SalesOrder(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}
}
