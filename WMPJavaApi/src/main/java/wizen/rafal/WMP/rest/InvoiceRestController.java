package wizen.rafal.WMP.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wizen.rafal.WMP.entity.Customer;
import wizen.rafal.WMP.entity.Employee;
import wizen.rafal.WMP.entity.PurchaseInvoice;
import wizen.rafal.WMP.entity.SalesInvoice;
import wizen.rafal.WMP.entity.ShippingOrder;
import wizen.rafal.WMP.entity.Transfer;
import wizen.rafal.WMP.service.BaseService;

@RestController
@RequestMapping("/api/invoice")
@CrossOrigin("http://localhost:4200")
public class InvoiceRestController {

	private BaseService baseService;
	
	@Autowired
	public InvoiceRestController(BaseService baseService) {
		this.baseService = baseService;
	}
	
	@GetMapping("/purchaseInvoices")
	public List<PurchaseInvoice> getPurchaseInvoicesList() {
		return baseService.getAll(PurchaseInvoice.class);
	}
	
	@GetMapping("/salesInvoices")
	public List<SalesInvoice> getSalesInvoicesList() {
		return baseService.getAll(SalesInvoice.class);
	}
	 
	@PostMapping("/purchaseInvoices")
	public PurchaseInvoice addNewPurchaseInvoice(@RequestBody PurchaseInvoice purchaseInvoice) {
		purchaseInvoice.setId(0);
		purchaseInvoice.setTransfer(baseService.getByID(Transfer.class, purchaseInvoice.getTransfer().getId()));
		purchaseInvoice.setCustomer(baseService.getByID(Customer.class, purchaseInvoice.getCustomer().getId()));
		purchaseInvoice.setEmployee(baseService.getByID(Employee.class, purchaseInvoice.getEmployee().getId()));
		baseService.saveOrUpdate(purchaseInvoice);
		return purchaseInvoice;
	}
	
	@PostMapping("/salesInvoices")
	public SalesInvoice addNewSalesInvoice(@RequestBody SalesInvoice salesInvoices) {
		salesInvoices.setId(0);
		salesInvoices.setTransfer(baseService.getByID(Transfer.class, salesInvoices.getTransfer().getId()));
		salesInvoices.setCustomer(baseService.getByID(Customer.class, salesInvoices.getCustomer().getId()));
		salesInvoices.setEmployee(baseService.getByID(Employee.class, salesInvoices.getEmployee().getId()));
		salesInvoices.setShippingOrder(baseService.getByID(ShippingOrder.class, salesInvoices.getShippingOrder().getId()));
		baseService.saveOrUpdate(salesInvoices);
		return salesInvoices;
	}
	
	
	
	
	
	
	
}
