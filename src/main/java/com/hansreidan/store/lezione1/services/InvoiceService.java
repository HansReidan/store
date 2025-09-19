package com.hansreidan.store.lezione1.services;

import com.hansreidan.store.lezione1.domain.Invoice;

import java.util.List;

public interface InvoiceService {

    public Invoice saveInvoice(Invoice invoice);
    public List<Invoice> getAll();
    public Invoice getInvoiceFromID(Long id);
    public void deleteInvoiceById(Long id);
    public void updateInvoice(Invoice invoice);
}
