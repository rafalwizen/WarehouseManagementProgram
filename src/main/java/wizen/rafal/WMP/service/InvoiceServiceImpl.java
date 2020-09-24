package wizen.rafal.WMP.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wizen.rafal.WMP.dao.GenericDAO;
import wizen.rafal.WMP.entity.PurchaseInvoice;
import wizen.rafal.WMP.entity.PurchaseOrder;
import wizen.rafal.WMP.entity.SalesInvoice;
import wizen.rafal.WMP.entity.SalesOrder;

@Service
public class InvoiceServiceImpl extends BaseServiceImpl implements InvoiceService  {

	public InvoiceServiceImpl(GenericDAO genericDAO) {
		super(genericDAO);
	}

	@Override
	@Transactional
	public String addOrderToSalesInvoice(int salesInvoiceId, int salesOrderId) {
		SalesInvoice salesInvoice = genericDAO.getByID(SalesInvoice.class, salesInvoiceId);
		SalesOrder salesOrder = genericDAO.getByID(SalesOrder.class, salesOrderId);
		if(salesInvoice == null) {return "Something went wrong - sales invoice doesn't exist";}
		if(salesOrder == null) {return "Something went wrong - sales order doesn't exist";}
		if(salesOrder.getSalesInvoice() != null) { return "Something went wrong - sales order is already added to some invoice";}
		salesInvoice.addSalesOrder(salesOrder);
		return "Sales order with id: " + salesOrderId + " added to sales invoice with id: " + salesInvoiceId;
	}

	@Override
	@Transactional
	public String addOrderToPurchaseInvoice(int purchaseInvoiceId, int purchaseOrderId) {
		PurchaseInvoice purchaseInvoice = genericDAO.getByID(PurchaseInvoice.class, purchaseInvoiceId);
		PurchaseOrder purchaseOrder = genericDAO.getByID(PurchaseOrder.class, purchaseOrderId);
		if(purchaseInvoice == null) {return "Something went wrong - purchase invoice doesn't exist";}
		if(purchaseOrder == null) {return "Something went wrong - purchase order doesn't exist";}
		if(purchaseOrder.getPurchaseInvoice() != null) { return "Something went wrong - purchase order is already added to some invoice";}
		purchaseInvoice.addPurchaseOrder(purchaseOrder);
		return "Purchase order with id: " + purchaseOrderId + " added to purchase invoice with id: " + purchaseInvoiceId;
	}

	
}
