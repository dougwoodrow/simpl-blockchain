package com.dougwoodrow.simpl.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.HashMap;

@RestController
public class AppController {

    @PostMapping(path = "/chain")
    public Response<HashMap<String, ?>> createBlock() {
    }
}
