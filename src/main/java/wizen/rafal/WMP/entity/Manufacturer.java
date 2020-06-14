package wizen.rafal.WMP.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="manufacturer")
@Getter
@Setter
@ToString
public class Manufacturer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="short_name")
	private String shortName;

	@OneToMany(mappedBy="manufacturer")
	private List<Item> items;
	
	public Manufacturer() {
		
	}
	
	public Manufacturer(String name, String shortName) {
		this.name = name;
		this.shortName = shortName;
	}
	
	
}
