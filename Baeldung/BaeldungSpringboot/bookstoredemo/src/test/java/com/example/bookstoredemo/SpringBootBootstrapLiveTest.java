package com.example.bookstoredemo;

import com.example.bookstoredemo.model.Book;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootBootstrapLiveTest {

    public static final String API_ROOT = "http://localhost:8081/api/books";

    private Book createRandomBook() {
        Book book = new Book();
        book.setTitle(randomAlphabetic(10));
        book.setAuthor(randomAlphabetic(15));
        return book;
    }

    private String createBookAsUri(Book book) {
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE) // application/json
                .body(book)
                .post(API_ROOT);

        return API_ROOT + "/" + response.jsonPath().get("id");
    }

    @Test
    public void whenGetBooksByTitle_thenOK() {
        Book book = createRandomBook();
        createBookAsUri(book);
        Response response = RestAssured.get(
                API_ROOT + "/title/" + book.getTitle()
        );

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertTrue(response.as(List.class).size() > 0);

    }
}
