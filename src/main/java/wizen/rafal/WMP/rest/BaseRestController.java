package wizen.rafal.WMP.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wizen.rafal.WMP.entity.Branch;
import wizen.rafal.WMP.entity.Employee;
import wizen.rafal.WMP.entity.Item;
import wizen.rafal.WMP.entity.Manufacturer;
import wizen.rafal.WMP.entity.Position;
import wizen.rafal.WMP.entity.PurchaseInvoice;
import wizen.rafal.WMP.entity.PurchaseOrder;
import wizen.rafal.WMP.entity.SalesInvoice;
import wizen.rafal.WMP.entity.ShippingOrder;
import wizen.rafal.WMP.entity.Transfer;
import wizen.rafal.WMP.entity.TransportCompany;
import wizen.rafal.WMP.service.BaseService;

@RestController
@RequestMapping("/api")
public class BaseRestController {

	// this class is already made for testing
	
	private BaseService baseService;

	@Autowired
	public BaseRestController(BaseService baseService) {
		this.baseService = baseService;
	}
	
	@GetMapping("/items")
	public List<Item> getItemsList() {
		return baseService.findAll(Item.class);
	}
	
	@GetMapping("/manufacturers")
	public List<Manufacturer> getManufacturersList() {
		return baseService.findAll(Manufacturer.class);
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployeesList() {
		return baseService.findAll(Employee.class);
	}
	
	@GetMapping("/branches")
	public List<Branch> getBranchesList() {
		return baseService.findAll(Branch.class);
	}
	
	@GetMapping("/positions")
	public List<Position> getPositionsList() {
		return baseService.findAll(Position.class);
	}
	
	@GetMapping("/shippingOrders")
	public List<ShippingOrder> getShippingOrdersList() {
		return baseService.findAll(ShippingOrder.class);
	}
	
	@GetMapping("/transportCompanies")
	public List<TransportCompany> getTransportCompaniesList() {
		return baseService.findAll(TransportCompany.class);
	}
	
	@GetMapping("/purchaseInvoices")
	public List<PurchaseInvoice> getPurchaseInvoicesList() {
		return baseService.findAll(PurchaseInvoice.class);
	}
	
	@GetMapping("/transfers")
	public List<Transfer> getTransfersList() {
		return baseService.findAll(Transfer.class);
	}
	
	@GetMapping("/purchaseOrders")
	public List<PurchaseOrder> getPurchaseOrderssList() {
		return baseService.findAll(PurchaseOrder.class);
	}
	
	@GetMapping("/salesInvoices")
	public List<SalesInvoice> getSalesInvoicesList() {
		return baseService.findAll(SalesInvoice.class);
	}
}
