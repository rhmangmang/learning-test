package com.spring.learning.demo.controller;

import com.spring.learning.demo.util.NeoProperties;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
//@ComponentScan(basePackages = {"com.spring.learning.demo"})
public class HelloTests {
    private MockMvc mvc;


    @Before
    public void setUp() throws Exception {
        System.out.println("before");
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public void getHello() throws Exception {
//        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        System.out.println("结果：" + resultActions.andReturn().getResponse().getContentAsString());
//                .andExpect(content().string(equalTo("Hello World")));
    }


    @Autowired
    private NeoProperties neoProperties;

    @Test
    public void testUtil() {
//        NeoProperties neoProperties = new NeoProperties();
        System.out.println(neoProperties.toString());
    }

}

