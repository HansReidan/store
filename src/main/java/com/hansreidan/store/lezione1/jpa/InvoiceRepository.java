package com.hansreidan.store.lezione1.jpa;

import com.hansreidan.store.lezione1.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

}
