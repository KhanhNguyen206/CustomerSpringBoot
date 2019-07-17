package com.khanhnn.customer.controller;

import com.khanhnn.customer.model.Customer;
import com.khanhnn.customer.model.Province;
import com.khanhnn.customer.service.CustomerService;
import com.khanhnn.customer.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Page<Province> provinces(Pageable pageable) {
        return provinceService.findAll(pageable);
    }

    @GetMapping("/customers")
    public ModelAndView list(@RequestParam("search") Optional<String> search, @PageableDefault(size = 5) Pageable pageable) {
        Page<Customer> customers;
        ModelAndView modelAndView = new ModelAndView("customer/list");

        if (search.isPresent()) {
            customers = customerService.findAllByFirstNameContaining(search.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("employee", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer
            , BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAllAttributes(bindingResult.getModel());
            return "customer/create";
        } else {
            customerService.save(customer);
            model.addAttribute("customer", customer);
            return "redirect:/customers";
        }
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@Valid @PathVariable Long id) {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        return modelAndView;

    }

    @PostMapping("/edit-customer")
    public String update(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/view-customer/{id}")
    public ModelAndView view(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer/view");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @GetMapping("/delete-customer/{id}")
    public String delete(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
           customerService.remove(id);
        }
        return "redirect:/customers";
    }
}