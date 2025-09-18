package com.hansreidan.store.jpa;

import com.hansreidan.store.first_project.assets.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

}
