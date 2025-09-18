package com.hansreidan.store.controllers;

import com.hansreidan.store.exceptions.InvoiceNotFoundException;
import com.hansreidan.store.first_project.Invoice;
import com.hansreidan.store.first_project.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/")
    public String showHomePage() {
        return "homePage";
    }

    @GetMapping("/register")
    public String showRegistration() {
        return "registerInvoicePage";
    }

    @PostMapping("/save")
    public String saveInvoice(@ModelAttribute Invoice invoice, Model model) {

            invoiceService.saveInvoice(invoice);
            Long id = invoiceService.saveInvoice(invoice).getId();
            String message = "Record with id : '"+id+"' is saved successfully !";
            model.addAttribute("message", message);
            return "registerInvoicePage";
    }

    @GetMapping("/getAllInvoices")
    public String getAllInvoices(@RequestParam(value = "message", required = false) String message, Model model) {
        List<Invoice> invoices = invoiceService.getAll();
        model.addAttribute("list", invoices);
        model.addAttribute("message", message);
        return "allInvoicesPage";
    }

    @GetMapping("/edit")
    public String getEditPage(Model model, RedirectAttributes redirectAttributes, @RequestParam Long id) {
        String page = null;
        try {
            Invoice invoice = invoiceService.getInvoiceFromID(id);
            model.addAttribute("invoice", invoice);
            page = "editInvoicePage";
        } catch (InvoiceNotFoundException e) {
            e.printStackTrace();
            redirectAttributes.addAttribute("message", e.getMessage());
            page="redirect:getAllInvoices";
        }
        return page;
    }

    @PostMapping("/update")
    public String updateInvoice(@ModelAttribute Invoice invoice, RedirectAttributes redirectAttributes) {
        invoiceService.updateInvoice(invoice);
        Long id = invoice.getId();
        redirectAttributes.addAttribute("message", "Invoice with id: '"+id+"' is updated successfully !");
        return "redirect:getAllInvoices";
    }

    @GetMapping("/delete")
    public String deleteInvoice(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        try {
            invoiceService.deleteInvoiceById(id);
            redirectAttributes.addAttribute("message", "Invoice with Id : '"+id+"' is removed successfully!");
        } catch (InvoiceNotFoundException e) {
            e.printStackTrace();
            redirectAttributes.addAttribute("message", e.getMessage());
        }
        return "redirect:getAllInvoices";
    }


}
