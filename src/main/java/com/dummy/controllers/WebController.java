package com.dummy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Intel on 3/20/2016.
 */
@Controller
public class WebController {

    @RequestMapping(value = "/AccessDenied",method = RequestMethod.GET)
    public String errorPage() {
        return "AccessDenied";
    }
}
