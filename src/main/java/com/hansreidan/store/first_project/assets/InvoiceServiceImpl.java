package com.hansreidan.store.first_project.assets;

import com.hansreidan.store.exceptions.InvoiceNotFoundException;
import com.hansreidan.store.jpa.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {


    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceFromID(Long id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if(invoice.isPresent()){
            return invoice.get();
        } else {
            throw new InvoiceNotFoundException("Invoice not found");
        }
    }

    @Override
    public void deleteInvoiceById(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }


}
