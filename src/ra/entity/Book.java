package ra.entity;

import ra.validate.InputMethod;

import java.util.Scanner;

public class Book implements IApp {
    private String bookId;
    //booktitle tối đa 100 kí tự
    private String bookTitle;
    private String author;
    private String publisher;
    private int publicationYear;
    private String category;
    private double price;
    private int quantity;

    public Book(){};
    public Book(String bookId, String bookTitle, String author, String publisher, int publicationYear, String category, double price, int quantity) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void inputData(Scanner sc) {
        Scanner scanner = new Scanner(System.in);
        this.bookId= String.valueOf(InputMethod.inputInteger(scanner));
        this.bookTitle=InputMethod.inputString(scanner,bookId, InputMethod.ERROR_EMPTY_STRING);
        this.author=InputMethod.inputString(scanner,author, InputMethod.ERROR_EMPTY_STRING);
        this.publisher=InputMethod.inputString(scanner,publisher, InputMethod.ERROR_EMPTY_STRING);
        this.publicationYear=InputMethod.inputInteger(scanner);
        this.category=InputMethod.inputString(scanner,category, InputMethod.ERROR_EMPTY_STRING);
        this.price=InputMethod.inputDouble(scanner,InputMethod.ERROR_NUM);
        this.quantity=InputMethod.inputInteger(scanner);
    }

    @Override
    public void displayData() {
        System.out.println("----------------------------Book Menu----------------------------\n");
        System.out.println("1. Hiển thị danh sách các cuốn sách\n");
        System.out.println("2. Thêm mới sách\n");
        System.out.println("3. Chỉnh sửa thông tin sách\n");
        System.out.println("4. Xóa sách\n");
        System.out.println("5. Tìm kiếm sách\n");
        System.out.println("6. Sắp xếp \n");
        System.out.println("0. Thoát chương trình\n");
        System.out.println("------------------------------------------------------------------------\n");
    }


}
