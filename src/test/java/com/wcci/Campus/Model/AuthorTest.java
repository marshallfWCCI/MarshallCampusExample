package com.wcci.Campus.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {

    @Test
    void test0() {
        final Author author = new Author("Me");
        assertEquals(0, author.getBooks().size());
    }

    @Test
    void test2() {
        final Author author = new Author("Me", new Book(), new Book());
        assertEquals(2, author.getBooks().size());
    }

    @Test
    void test3() {
        final Author author = new Author("Me", new Book(), new Book(), new Book());
        assertEquals(3, author.getBooks().size());
    }
}