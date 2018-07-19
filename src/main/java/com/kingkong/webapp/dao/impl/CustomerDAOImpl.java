/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kingkong.webapp.dao.impl;

import com.kingkong.webapp.dao.CustomerDAO;
import com.kingkong.webapp.entity.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kiran
 */

@Repository(value="customerDAO")

public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
     private JdbcTemplate jdbcTemplate;
    //--used of dependency injection.. only reuse of template..
    
    
    @Override
    public List<Customer> getAll() throws ClassNotFoundException, SQLException {
        String sql="SELECT * FROM tbl_customers";
        return jdbcTemplate.query(sql, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int i) throws SQLException {
                Customer c=new Customer();
                c.setId(rs.getInt("id"));
                c.setFirstName(rs.getString("first_name"));
                c.setLastName(rs.getString("last_name"));
                c.setEmail(rs.getString("email"));
                c.setContactNo(rs.getString("contact"));
                
                c.setStatus(rs.getBoolean("status"));
             
                return c;
            }
        });
                
    }

    @Override
    public Customer getById(int id) throws ClassNotFoundException, SQLException {
     String sql="SELECT * FROM tbl_customers WHERE customer_id=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id} ,new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int i) throws SQLException {
                Customer c=new Customer();
                c.setId(rs.getInt("id"));
                c.setFirstName(rs.getString("first_name"));
                c.setLastName(rs.getString("last_name"));
                c.setEmail(rs.getString("email"));
                c.setContactNo(rs.getString("contact"));
                
                c.setStatus(rs.getBoolean("status"));
             
                return c;
            }
        });
           
    }

    @Override
    public int insert(Customer c) throws ClassNotFoundException, SQLException {
        String sql="INSERT INTO tbl_customers(first_name,last_name,email,contact,status) VALUE(?,?,?,?,?)";
        
        return jdbcTemplate.update(sql,new Object[]{
            c.getFirstName(),c.getLastName(),c.getEmail(),c.getContactNo(),c.isStatus()
        });        
                
                }

    @Override
    public int update(Customer c) throws ClassNotFoundException, SQLException {
        String sql="UPDATE tbl_customers  SET first_name=?,last_name=?,email=?,contact=?,status=?,modified_date=CURRENT_TIMESTAMP  WHERE customer_id=?";
        
        return jdbcTemplate.update(sql,new Object[]{
            c.getFirstName(),c.getLastName(),c.getEmail(),c.getContactNo(),c.isStatus(),c.getId()
        });        
        
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String sql="DELETE FROM tbl_customers WHERE customer_id=?";
        
        return jdbcTemplate.update(sql,new Object[]{
            id
        });        
        
    }

    
    
}
