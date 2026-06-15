package bookstoread;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class BookShelf {
    private final List<Book> books = new ArrayList<>();



    public List<Book> books() {
        return Collections.unmodifiableList(books);
    }


    public void add(Book...bookToAdd) {
        books.addAll(List.of(bookToAdd));
    }

    public List<Book> arrange() {
        books.stream().sorted().collect(Collectors.toList());
        return books;
    }
}