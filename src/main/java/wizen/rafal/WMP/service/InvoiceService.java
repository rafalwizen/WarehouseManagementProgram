package wizen.rafal.WMP.service;

import wizen.rafal.WMP.entity.PurchaseOrder;
import wizen.rafal.WMP.entity.SalesOrder;

public interface InvoiceService {

	public SalesOrder addOrderToSalesInvoice(int salesInvoiceId, int salesOrderId);
	public PurchaseOrder addOrderToPurchaseInvoice(int purchaseInvoiceId, int purchaseOrderId);
}
