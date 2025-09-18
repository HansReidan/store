package com.hansreidan.store.first_project;

import java.util.List;

public interface InvoiceService {

    public Invoice saveInvoice(Invoice invoice);
    public List<Invoice> getAll();
    public Invoice getInvoiceFromID(Long id);
    public void deleteInvoiceById(Long id);
    public void updateInvoice(Invoice invoice);
}
