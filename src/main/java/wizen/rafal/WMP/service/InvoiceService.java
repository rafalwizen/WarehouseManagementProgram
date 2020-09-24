package wizen.rafal.WMP.service;

public interface InvoiceService {

	public String addOrderToSalesInvoice(int salesInvoiceId, int salesOrderId);
	public String addOrderToPurchaseInvoice(int purchaseInvoiceId, int purchaseOrderId);
}
