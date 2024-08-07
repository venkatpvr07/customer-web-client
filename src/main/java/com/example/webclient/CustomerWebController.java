package com.example.webclient;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
// import com.example.webclient.
@Controller
@RequestMapping("/web/customers")
public class CustomerWebController {

    @Autowired
    private RestTemplate restTemplate;
    private String customerUrl = "http://localhost:8080/customers";

    @GetMapping()
    public String getAllCustomers(Model model) {
        Customer[] customers = restTemplate.getForObject(customerUrl, Customer[].class);
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/create")
    public String createCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @GetMapping("/edit/{id}")
    public String editCustomerForm(@PathVariable Long id, Model model) {
        Customer customer = restTemplate.getForObject(customerUrl + "/" + id, Customer.class);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping()
    public String createCustomer(@ModelAttribute Customer customer) {
        System.out.println(customer.getName());
        restTemplate.postForObject(customerUrl, customer, Customer.class);
        return "redirect:/web/customers";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable Long id, @ModelAttribute Customer customer) {
        restTemplate.put(customerUrl + "/" + id, customer);
        return "redirect:/web/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        restTemplate.delete(customerUrl + "/" + id);
        return "redirect:/web/customers";
    }

}
