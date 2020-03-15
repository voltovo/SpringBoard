package com.rubypaper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

/**
 * BoardControllerTest
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BoardControllerTest {

    /* @Autowired
    private MockMvc mockMvc; */
    //RANDOM_PORT를 사용하며느 더이상 서블릿 컨테이너를 모킹하지 않아서
    //MockMvc 객체를 목업 할 수 없으므로, TestRestTemplate 객체 주입
    @Autowired
    private TestRestTemplate restTemplate;

    /* @Test
    public void testHello()throws Exception{
        mockMvc.perform(get("/hello").param("name","둘리"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello: 둘리"))
        .andDo(print());
    } */

    /* @Test
    public void testHello() throws Exception{
        String result = restTemplate.getForObject("/hello?name=둘리", String.class);
        assertEquals("Hello : 둘리", result);
    } */

    @Test
    public void testGetBoard()throws Exception{
        BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
        assertEquals("테스터", board.getWriter());
    }
    
}