package wizen.rafal.WMP.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
import wizen.rafal.WMP.entity.SalesOrder;
import wizen.rafal.WMP.entity.ShippingOrder;
import wizen.rafal.WMP.entity.Transfer;
import wizen.rafal.WMP.entity.TransportCompany;
import wizen.rafal.WMP.service.BaseService;

@RestController
@RequestMapping("/api/test")
public class BaseRestController {

	// this class is already made for testing
	
	private BaseService baseService;

	@Autowired
	public BaseRestController(BaseService baseService) {
		this.baseService = baseService;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> getEmployeesList() {
		return baseService.getAll(Employee.class);
	}
	
	@GetMapping("/branches")
	public List<Branch> getBranchesList() {
		return baseService.getAll(Branch.class);
	}
	
	@GetMapping("/positions")
	public List<Position> getPositionsList() {
		return baseService.getAll(Position.class);
	}
	
	@GetMapping("/shippingOrders")
	public List<ShippingOrder> getShippingOrdersList() {
		return baseService.getAll(ShippingOrder.class);
	}
	
	@GetMapping("/transportCompanies")
	public List<TransportCompany> getTransportCompaniesList() {
		return baseService.getAll(TransportCompany.class);
	}
	
	@GetMapping("/transfers")
	public List<Transfer> getTransfersList() {
		return baseService.getAll(Transfer.class);
	}
	
	@GetMapping("/purchaseOrders")
	public List<PurchaseOrder> getPurchaseOrdersList() {
		return baseService.getAll(PurchaseOrder.class);
	}
	
	@GetMapping("/salesOrders")
	public List<SalesOrder> getSalesOrdersList() {
		return baseService.getAll(SalesOrder.class);
	}
}
