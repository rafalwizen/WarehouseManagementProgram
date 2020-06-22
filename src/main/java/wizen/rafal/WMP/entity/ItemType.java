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
@Table(name="item_type")
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

	@OneToMany(mappedBy="itemType")
	@JsonIgnore
	private List<Item> items;
	
	public ItemType() {
		
	}
	
	public ItemType(boolean belongsToCumstomsWarehouse, boolean isDamaged, boolean isTeritorialyRestricted) {
		this.belongsToCumstomsWarehouse = belongsToCumstomsWarehouse;
		this.isDamaged = isDamaged;
		this.isTeritorialyRestricted = isTeritorialyRestricted;
	}
	
	
}
