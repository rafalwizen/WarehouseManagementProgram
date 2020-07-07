package wizen.rafal.WMP.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ItemRestController {

	private BaseService baseService;
	
	@Autowired
	public ItemRestController(BaseService baseService) {
		this.baseService = baseService;
	}
	
	@PostMapping("/items")
	public Item addNewItem(@RequestBody Item item) {
		item.setId(0);
		item.setManufacturer(baseService.findByID(Manufacturer.class, item.getManufacturer().getId()));
		baseService.saveOrUpdate(item);
		return item;
	}
	
	@GetMapping("/items/{itemId}")
	public Item getItemById(@PathVariable int itemId) {
		return baseService.findByID(Item.class, itemId);
	}
	
	@GetMapping("/items")
	public List<Item> getItemsList() {
		return baseService.findAll(Item.class);
	}
	
	@GetMapping("/manufacturers")
	public List<Manufacturer> getManufacturersList() {
		return baseService.findAll(Manufacturer.class);
	}
	
}
