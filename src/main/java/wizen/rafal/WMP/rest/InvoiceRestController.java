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

import wizen.rafal.WMP.entity.Customer;
import wizen.rafal.WMP.entity.Employee;
import wizen.rafal.WMP.entity.PurchaseInvoice;
import wizen.rafal.WMP.entity.PurchaseOrder;
import wizen.rafal.WMP.entity.SalesInvoice;
import wizen.rafal.WMP.entity.SalesOrder;
import wizen.rafal.WMP.entity.ShippingOrder;
import wizen.rafal.WMP.entity.Transfer;
import wizen.rafal.WMP.entity.TransportCompany;
import wizen.rafal.WMP.service.BaseService;
import wizen.rafal.WMP.service.InvoiceService;

@RestController
@RequestMapping("/api/invoice")
@CrossOrigin("http://localhost:4200")
public class InvoiceRestController {

	private BaseService baseService;
	private InvoiceService invoiceService;
	
	@Autowired
	public InvoiceRestController(BaseService baseService, InvoiceService invoiceService) {
		this.baseService = baseService;
		this.invoiceService = invoiceService;
	}
	
	@GetMapping("/purchaseInvoices")
	public List<PurchaseInvoice> getPurchaseInvoicesList() {
		return baseService.getAll(PurchaseInvoice.class);
	}
	
	@GetMapping("/salesInvoices")
	public List<SalesInvoice> getSalesInvoicesList() {
		return baseService.getAll(SalesInvoice.class);
	}
	
	@GetMapping("/customers")
	public List<Customer> getCustomersList() {
		return baseService.getAll(Customer.class);
	}
	 
	@PostMapping("/purchaseInvoices")
	public PurchaseInvoice addNewPurchaseInvoice(@RequestBody PurchaseInvoice purchaseInvoice) {
		purchaseInvoice.setId(0);
		Transfer tempTransfer = new Transfer();
		baseService.saveOrUpdate(tempTransfer);
		purchaseInvoice.setTransfer(tempTransfer);
		purchaseInvoice.setCustomer(baseService.getByID(Customer.class, purchaseInvoice.getCustomer().getId()));
		purchaseInvoice.setEmployee(baseService.getByID(Employee.class, purchaseInvoice.getEmployee().getId()));
		baseService.saveOrUpdate(purchaseInvoice);
		return purchaseInvoice;
	}
	
	@PostMapping("/salesInvoices")
	public SalesInvoice addNewSalesInvoice(@RequestBody SalesInvoice salesInvoices) {
		salesInvoices.setId(0);
		Transfer tempTransfer = new Transfer();
		baseService.saveOrUpdate(tempTransfer);
		salesInvoices.setTransfer(tempTransfer);
		salesInvoices.setCustomer(baseService.getByID(Customer.class, salesInvoices.getCustomer().getId()));
		salesInvoices.setEmployee(baseService.getByID(Employee.class, salesInvoices.getEmployee().getId()));
		ShippingOrder tempShippingOrder = new ShippingOrder();
		tempShippingOrder.setTransportCompany(baseService.getByID(TransportCompany.class, 1));
		baseService.saveOrUpdate(tempShippingOrder);
		salesInvoices.setShippingOrder(tempShippingOrder);
		baseService.saveOrUpdate(salesInvoices);
		return salesInvoices;
	}
	
	@PostMapping("/customers")
	public Customer addNewCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		baseService.saveOrUpdate(customer);
		return customer;
	}
	
	@GetMapping("/purchaseInvoices/{purchaseInvoiceId}")
	public PurchaseInvoice getPurchaseInvoiceById(@PathVariable int purchaseInvoiceId) {
		return baseService.getByID(PurchaseInvoice.class, purchaseInvoiceId);
	}
	
	@GetMapping("/salesInvoices/{salesInvoiceId}")
	public SalesInvoice getSalesInvoiceById(@PathVariable int salesInvoiceId) {
		return baseService.getByID(SalesInvoice.class, salesInvoiceId);
	}
	
	@DeleteMapping("/purchaseInvoices/{purchaseInvoiceId}")
	public String deletePurchaseInvoice(@PathVariable int purchaseInvoiceId) {
		PurchaseInvoice tempInvoice = baseService.getByID(PurchaseInvoice.class, purchaseInvoiceId);
		if (tempInvoice == null) {return "Purchase invoice id not found: " + purchaseInvoiceId;}
		baseService.delete(PurchaseInvoice.class, purchaseInvoiceId);
		return "Deleted purchase invoice id - " + purchaseInvoiceId;
	}
	
	@DeleteMapping("/salesInvoices/{salesInvoiceId}")
	public String deleteSalesInvoice(@PathVariable int salesInvoiceId) {
		SalesInvoice tempInvoice = baseService.getByID(SalesInvoice.class, salesInvoiceId);
		if (tempInvoice == null) {return "Sales invoice id not found: " + salesInvoiceId;}
		baseService.delete(SalesInvoice.class, salesInvoiceId);
		return "Deleted sales invoice id - " + salesInvoiceId;
	}
	
	@GetMapping("/salesInvoices/{salesInvoiceId}/{salesOrderId}")
	public String addOrderToSalesInvoice (@PathVariable int salesInvoiceId, @PathVariable int salesOrderId) {
		return invoiceService.addOrderToSalesInvoice(salesInvoiceId, salesOrderId);
	}
	
	@GetMapping("/purchaseInvoices/{purchaseInvoiceId}/{purchaseOrderId}")
	public String addOrderToPurchaseInvoice (@PathVariable int purchaseInvoiceId, @PathVariable int purchaseOrderId) {
		return invoiceService.addOrderToPurchaseInvoice(purchaseInvoiceId, purchaseOrderId);
	}
	
	
	
	
}
