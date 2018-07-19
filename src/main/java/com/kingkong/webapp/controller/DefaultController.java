/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kingkong.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author kiran
 */

@Controller
@RequestMapping(value="/")
public class DefaultController {
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "<h1> Spring Framework Works </h1>";
    }
}
