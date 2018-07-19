/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kingkong.webapp.controller.admin;

import com.kingkong.webapp.entity.Customer;
import com.kingkong.webapp.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kiran
 */
@Controller
@RequestMapping(value = "/admin/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    // @ResponseBody

    public String index(Model model) {

        try {

            model.addAttribute("customers", customerService.getAll());
            customerService.delete(9);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "/admin/customer/index";
        
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") int id) {

        try {

            model.addAttribute("customer", customerService.getById(id));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "/admin/customer/edit";

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {

        try {

            customerService.delete(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "redirect:/admin/customer";

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Customer") Customer customer) {
        /*
        try {
            if(customer.getId()>0){
        customerService.update(customer);}
            else{
                customerService.insert(customer);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
         */
        return "redirect:admin/customer?success&action=save";

    }
}
