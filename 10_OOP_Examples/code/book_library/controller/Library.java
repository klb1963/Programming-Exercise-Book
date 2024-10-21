package book_library.controller;

import book_library.model.Book;

public class Library {

    // fields
    private Book[] books;
    private int size; // текущее кол-во книг


    // constructor
    public Library(int capacity) {
        this.books = new Book[capacity];
        this.size = 0;
    }

    // CRUD methods

    public boolean addBook(Book book){
        // negative cases
        if(book == null || size == books.length || !(findBook(book.getIsbn()) == null)){
            return false;
        }
        // positive case
        books[size] = book;
        size++;
        return true;
    }


    public void printBooks(){
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public Book findBook(long isbn){
        for (int i = 0; i < size; i++) {
            if(books[i].getIsbn() == isbn){
                return books[i];
            }
        }
        return null;
    }

    // Book removeBook(long isbn)
    // size--

    // boolean updateBook()


    public int size(){
        return size;
    }

}
