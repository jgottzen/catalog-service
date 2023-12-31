package com.polarbookshop.catalogservice.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;

import java.util.List;

@Component
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository bookRepository;

    public BookDataLoader(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookData() {
        bookRepository.deleteAll();
        final Book book1 = Book.of("1234567891", "Northern Lights", "Lyra Silverstar", 9.90);
        final Book book2 = Book.of("1234567892", "Polar Journey", "Iorek Polarson", 12.90);
        bookRepository.saveAll(List.of(book1, book2));
    }
}
