package wizen.rafal.WMP.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wizen.rafal.WMP.entity.Item;
import wizen.rafal.WMP.entity.Manufacturer;
import wizen.rafal.WMP.service.BaseService;

@RestController
@RequestMapping("/api/item")
@CrossOrigin("http://localhost:4200")
public class ItemRestController {

	private BaseService baseService;
	
	@Autowired
	public ItemRestController(BaseService baseService) {
		this.baseService = baseService;
	}
	
	@GetMapping("/items")
	public List<Item> getItemsList() {
		return baseService.getAll(Item.class);
	}
	
	@PostMapping("/items")
	public Item addNewItem(@RequestBody Item item) {
		item.setId(0);
		item.setManufacturer(baseService.getByID(Manufacturer.class, item.getManufacturer().getId()));
		baseService.saveOrUpdate(item);
		return item;
	}
	
	@GetMapping("/items/{itemId}")
	public Item getItemById(@PathVariable int itemId) {
		return baseService.getByID(Item.class, itemId);
	}
	
	@DeleteMapping("/items/{itemId}")
	public String deleteItem(@PathVariable int itemId) {
		Item tempItem = baseService.getByID(Item.class, itemId);
		if (tempItem == null) {return "Item id not found: " + itemId;}
		baseService.delete(Item.class, itemId);
		return "Deleted item id - " + itemId;
	}
	
	@GetMapping("/manufacturers")
	public List<Manufacturer> getManufacturersList() {
		return baseService.getAll(Manufacturer.class);
	}
	
	@PostMapping("/manufacturers")
	public Manufacturer addNewManufacturer(@RequestBody Manufacturer manufacturer) {
		manufacturer.setId(0);
		baseService.saveOrUpdate(manufacturer);
		return manufacturer;
	}
}
