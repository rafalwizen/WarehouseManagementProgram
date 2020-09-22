package wizen.rafal.WMP.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wizen.rafal.WMP.dao.GenericDAO;
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

}
