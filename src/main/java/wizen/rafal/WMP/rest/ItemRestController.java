package wizen.rafal.WMP.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wizen.rafal.WMP.entity.Item;
import wizen.rafal.WMP.entity.Manufacturer;
import wizen.rafal.WMP.service.ItemService;
import wizen.rafal.WMP.service.ManufacturerService;

@RestController
@RequestMapping("/api")
public class ItemRestController {

	private ItemService itemService;
	private ManufacturerService manufacturerService;

	@Autowired
	public ItemRestController(ItemService itemService, ManufacturerService manufacturerService) {
		this.itemService = itemService;
		this.manufacturerService = manufacturerService;
	}
	
	@GetMapping("/items")
	public List<Item> getItemsList() {
		return itemService.findAll(Item.class);
	}
	
	@GetMapping("/manufacturers")
	public List<Manufacturer> getManufacturersList() {
		return manufacturerService.findAll();
	}
}
