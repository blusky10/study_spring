package com.study.spring.book.web;

import com.study.spring.domain.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by SDS on 2017-06-12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTest {


    private HttpMessageConverter messageConverter;
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
                                        MediaType.APPLICATION_JSON.getSubtype(),
                                        Charset.forName("utf8"));

    private MockMvc mockMvc;

    @MockBean
    BookController bookController;

    @Autowired
    void setConverters(HttpMessageConverter[] converters){
        this.messageConverter = Arrays.asList(converters).stream().filter(
                converter -> converter instanceof MappingJackson2HttpMessageConverter).
                findAny().get();
    }

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }


    @Test
    public void getBookTest() throws Exception {
        given(this.bookController.getBook(new Long(1)))
                .willReturn(new Book("Homes"));

        mockMvc.perform(get("/book/{bookId}", 1))

                .andExpect(content().contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$['title']", containsString("Homes")))
                .andDo(print());
    }
}
