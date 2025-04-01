package ra.business;

import ra.entity.Book;

public class BookBusiness {
    public static final Book[] books = new Book[100];
    private static int bookCount = 0;

    public static void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
        } else {
            System.err.println("Danh sách book đã đầy. Không thể thêm book mới.");
        }
    }

    public static int getBookCount() {
        return bookCount;
    }
}
