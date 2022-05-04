package com.example.testingweb;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest
@RunWith(SpringRunner.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService service;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(service.greet()).thenReturn("Hello, Mock");
//        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello, Mock")));
        this.mockMvc.perform(get("/greeting"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("Hello, Mock")))
        ;
    }

    @Test
    public void ModelAttribute의_LocalDate는_변환된다() throws Exception {
        when(service.getCalled()).thenReturn("get success");

        //given
        String url = "/get?name=jojoldu&requestDateTime=2018-12-15T10:00:00"; //yyyy-MM-ddTHH:mm:ss

        //when
        ResultActions resultActions = this.mockMvc.perform(get(url));

        //then
        resultActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("get success")));
    }
}