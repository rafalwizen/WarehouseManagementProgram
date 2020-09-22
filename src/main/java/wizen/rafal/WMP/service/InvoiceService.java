package wizen.rafal.WMP.service;

public interface InvoiceService {

	public void addOrderToSalesInvoice(int salesInvoiceId, int salesOrderId);
	public void addOrderToPurchaseInvoice(int purchaseInvoiceId, int purchaseOrderId);
}
