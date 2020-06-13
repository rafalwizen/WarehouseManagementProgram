package wizen.rafal.WMP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class ItemType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="belongs_to_cumstoms_warehouse")
	private boolean belongsToCumstomsWarehouse;
	
	@Column(name="is_damaged")
	private boolean isDamaged;
	
	@Column(name="is_teritorialy_restricted")
	private boolean isTeritorialyRestricted;

	public ItemType(boolean belongsToCumstomsWarehouse, boolean isDamaged, boolean isTeritorialyRestricted) {
		this.belongsToCumstomsWarehouse = belongsToCumstomsWarehouse;
		this.isDamaged = isDamaged;
		this.isTeritorialyRestricted = isTeritorialyRestricted;
	}
	
	
}
