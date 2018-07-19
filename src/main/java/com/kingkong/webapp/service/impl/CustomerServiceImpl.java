/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kingkong.webapp.service.impl;

import com.kingkong.webapp.dao.CustomerDAO;
import com.kingkong.webapp.entity.Customer;
import com.kingkong.webapp.service.CustomerService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kiran
 */
@Service(value="customerService")
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDAO customerDAO;
    
    
    @Override
    public List<Customer> getAll() throws ClassNotFoundException, SQLException {
        return customerDAO.getAll();
        }

    @Override
    public Customer getById(int id) throws ClassNotFoundException, SQLException {
       return customerDAO.getById(id);
    }

    @Override
    public int insert(Customer c) throws ClassNotFoundException, SQLException {
        return customerDAO.insert(c);
    }

    @Override
    public int update(Customer c) throws ClassNotFoundException, SQLException {
        return customerDAO.update(c);
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        return customerDAO.delete(id);
    }
    
}
