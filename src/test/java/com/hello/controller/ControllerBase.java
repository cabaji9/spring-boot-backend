package com.hello.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ControllerBase {
    protected MockMvc mockMvc;
    protected ObjectMapper mapper;

    public void setUp(Object object){
        mockMvc = MockMvcBuilders.standaloneSetup(object).build();
        mapper = new ObjectMapper();
    }
}
