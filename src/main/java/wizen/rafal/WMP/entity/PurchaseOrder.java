package wizen.rafal.WMP.entity;

import javax.persistence.Entity;
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

	private int id;
	
	private int quantity;
	
	public PurchaseOrder() {
		
	}

	public PurchaseOrder(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}
	
}
