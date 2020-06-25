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
@Table(name="purchase_order")
@Getter
@Setter
@ToString
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="quantity")
	private int quantity;
	
	public PurchaseOrder() {
		
	}

	public PurchaseOrder(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}
	
}
