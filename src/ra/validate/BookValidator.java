package ra.validate;

import ra.business.BookBusiness;
import ra.entity.Book;

import java.util.Scanner;

import static ra.validate.InputMethod.*;

public class BookValidator {
    public static String inputBookTitle(Scanner sc){
        while (true) {
            String bookTitle = inputString(sc, "Nhập tên sản phẩm", InputMethod.ERROR_EMPTY_STRING);

            //validate độ dài chuỗi
            ValidateString validator = new ValidateString(0, 100, null);
            if (!validator.isValid(bookTitle)) {
                System.err.println(validator.getErrorMessage());
                continue;
            }

            // Check for existing name
            if (!existsByName(bookTitle)) {
                return bookTitle;
            }

            System.err.println("Tên sách đã tồn tại. Vui lòng nhập tên khác.");
        }
    }
    public static String inputAuhor(Scanner sc) {
        while (true) {
            String author = inputString(sc, "Nhập tên tác giả", InputMethod.ERROR_EMPTY_STRING);
            ValidateString validator = new ValidateString(0, 50, null);
            if (validator.isValid(author)) {
                return author;
            }
            System.err.println(validator.getErrorMessage());
        }
    }
    public static String inputPublisher(Scanner sc) {
        while (true) {
            String publisher = inputString(sc, "Nhập tên nhà xuất bản", InputMethod.ERROR_EMPTY_STRING);
            ValidateString validator = new ValidateString(0, 100, null);
            if (validator.isValid(publisher)) {
                return publisher;
            }
            System.err.println(validator.getErrorMessage());
        }
    }
    public static int inputPublicationYear (Scanner sc) {
        while (true) {
            String publicationYear = inputString(sc, "Nhập năm xuất bản", ERROR_INTEGER);
            ValidateString validator = new ValidateString(0, 100, null);
            if (validator.isValid(publicationYear)) {
                return Integer.parseInt(publicationYear);
            }
            System.err.println(validator.getErrorMessage());
        }
    }
    public static String inputCategory(Scanner sc) {
        while (true) {
            String category = inputString(sc, "Nhập thể loại sách", InputMethod.ERROR_EMPTY_STRING);
            ValidateString validator = new ValidateString(0, 100, null);
            if (validator.isValid(category)) {
                return category;
            }
            System.err.println(validator.getErrorMessage());
        }
    }
    public static double inputPrice(Scanner sc) {
        while (true) {
            String price = inputString(sc, "Nhập giá sách", ERROR_NUM);
            ValidateString validator = new ValidateString(1, 100, null);
            if (validator.isValid(price)) {
                return Double.parseDouble(price);
            }
            System.err.println(validator.getErrorMessage());
        }
    }
    public static int inputQuantity(Scanner sc) {
        while (true) {
            String quantity = inputString(sc, "Nhập số lượng sách", ERROR_INTEGER);
            ValidateString validator = new ValidateString(1, 100, null);
            if (validator.isValid(quantity)) {
                return Integer.parseInt(quantity);
            }
            System.err.println(validator.getErrorMessage());
        }
    }
    private static boolean existsByName(String name) {
        if (BookBusiness.books == null) {
            return false;
        }

        for (Book book : BookBusiness.books) {
            if (book != null && book.getBookTitle() != null &&
                    book.getBookTitle().trim().equalsIgnoreCase(name.trim())) {
                return true;
            }
        }
        return false;
    }

}
