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

    //Methode d'ajout des livres
    public void add(Book...bookToAdd) {
        books.addAll(List.of(bookToAdd));
    }

    //Methode de tri des livres
    public List<Book> arrange() {
        return books.stream().sorted().collect(Collectors.toList());
    }

    public List<Book> arrange(Comparator<Book> criteria) {
        return books.stream().sorted(criteria).collect(Collectors.toList());
    }
}