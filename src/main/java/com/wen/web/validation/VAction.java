/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.wen.web.validation;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author wsy48420
 * @version $Id: VAction.java, v 0.1 2017年8月15日 下午5:43:19 wsy48420 Exp $
 */
@Controller
public class VAction {
    private static final Logger logger = LoggerFactory.getLogger(VAction.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String index() {
        logger.info("test");
        return "test";
    }

    @RequestMapping(value = "test", method = RequestMethod.POST)
    public String post(@Validated User user123, BindingResult br) {
        if (br.hasErrors()) {
            return "error";
        }
        logger.info("test");
        return "test";
    }
}
