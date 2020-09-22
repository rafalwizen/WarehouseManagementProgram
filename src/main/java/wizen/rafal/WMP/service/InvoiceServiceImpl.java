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
	public void addOrderToSalesInvoice(int salesInvoiceId, int salesOrderId) {
		SalesInvoice salesInvoice = genericDAO.getByID(SalesInvoice.class, salesInvoiceId);
		salesInvoice.addSalesOrder(genericDAO.getByID(SalesOrder.class, salesOrderId));
	}

	@Override
	@Transactional
	public void addOrderToPurchaseInvoice(int purchaseInvoiceId, int purchaseOrderId) {
		PurchaseInvoice purchaseInvoice = genericDAO.getByID(PurchaseInvoice.class, purchaseInvoiceId);
		purchaseInvoice.addPurchaseOrder(genericDAO.getByID(PurchaseOrder.class, purchaseOrderId));
	}

	
}
