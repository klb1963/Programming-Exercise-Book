package book_library.test;

import book_library.controller.Library;
import book_library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    Library library;
    Book[] books;

    @BeforeEach
    void setUp() {
        // int size = 0;
        library = new Library(5);

        books = new Book[5];

        books[0] = new Book("1984", "Orwell", 1_111_111_111_110L, 2010);
        books[1] = new Book("T1", "A1", 1_111_111_111_111L, 2011);
        books[2] = new Book("T2", "A2", 1_111_111_111_112L, 2009);
        books[3] = new Book("T3", "A3", 1_111_111_111_113L, 2005);

        // TODO - положить объекты в массив, который "внутри" объекта library
        for (int i = 0; i < 4; i++) {
            library.addBook(books[i]);
            System.out.println(books[i]);
        }
    }

    @Test
    void addBookTest(){
        //add already existed
        assertFalse(library.addBook(books[0]));
        // add book == nul
        assertFalse(library.addBook(null));
        // add real new boat
        Book newBook = new Book("T4", "A4", 1_111_111_111_114L, 2024);
        assertTrue(library.addBook(newBook));
        //add extra size
        Book oneMoreBook = new Book("T5", "A5", 1_111_111_111_115L, 2025);
        assertFalse(library.addBook(oneMoreBook));
    }


    @Test
    void findBookTest(){
        library.printBooks();
        Book foundBook = library.findBook(1_111_111_111_111L);
        System.out.println("--------------------------------------");
        System.out.println(foundBook);
        System.out.println(books[1]);
        assertEquals(books[0], library.findBook(1_111_111_111_110L)); // find existed book
        assertNull(library.findBook(1_111_111_111_119L)); // find absent book
    }

    @Test
    void sizeTest(){
        assertEquals(4, library.size());
    }

    @Test
    void pintBooksTest(){
        System.out.println("=========================");
        library.printBooks();
    }

}