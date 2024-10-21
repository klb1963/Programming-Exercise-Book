package book_library;

import book_library.model.Book;

public class LibraryAppl {
    public static void main(String[] args) {

        Book[] books = new Book[5];

        books[0] = new Book("1984", "Orwell", 1_111_111_111_110L, 2010);

        System.out.println(books[0]);


    }
}
