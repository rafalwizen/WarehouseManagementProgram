package wizen.rafal.WMP.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wizen.rafal.WMP.entity.Item;
import wizen.rafal.WMP.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemRestController {

	private ItemService itemService;

	@Autowired
	public ItemRestController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@GetMapping("/items")
	public List<Item> getItemsList() {
		return itemService.findAll();
	}
}
