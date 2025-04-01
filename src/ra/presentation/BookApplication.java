package ra.presentation;

import ra.business.BookBusiness;
import ra.entity.Book;
import ra.validate.InputMethod;

import java.util.Scanner;

public class BookApplication {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = InputMethod.inputInteger(scanner);

            switch (choice) {
                case 1:
                    displayAllBooks();
                    break;
                case 2:
                    inputBook();
                    break;
                case 3:
//                    changeProductStatus();
                    break;
                case 4:
//                    deleteBookById();
                    break;
                case 5:
                    searchProductByName();
                    break;
                case 6:
//                    sortProductsByInterest();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.err.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("----------------------------Book Menu----------------------------\n");
        System.out.println("1. Hiển thị danh sách các cuốn sách\n");
        System.out.println("2. Thêm mới sách\n");
        System.out.println("3. Chỉnh sửa thông tin sách\n");
        System.out.println("4. Xóa sách\n");
        System.out.println("5. Tìm kiếm sách\n");
        System.out.println("6. Sắp xếp \n");
        System.out.println("0. Thoát chương trình\n");
        System.out.println("------------------------------------------------------------------------\n");
        System.out.print("Chọn chức năng (1-7): ");
    }

    private static void inputBook() {
        System.out.print("Nhập số lượng sản phẩm cần thêm: ");
        int n = InputMethod.inputInteger(scanner);

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin cho sản phẩm thứ " + (i + 1));

            Book newBook = new Book();
            newBook.inputData(scanner);

            BookBusiness.addBook(newBook);
        }
    }

    private static void displayAllBooks() {
        boolean hasBooks = false;
        for (Book book : BookBusiness.books) {
            if (book != null) {
                book.displayData();
                hasBooks = true;
            }
        }

        if (!hasBooks) {
            System.out.println("Không có sản phẩm nào để hiển thị.");
        }
    }

//    private static void sortProductsByInterest() {
//        int productCount = 0;
//        for (Product p : ProductBusiness.products) {
//            if (p != null) productCount++;
//        }
//
//        //bubble sort
//        for (int i = 0; i < productCount - 1; i++) {
//            for (int j = 0; j < productCount - i - 1; j++) {
//                if (ProductBusiness.products[j] != null && ProductBusiness.products[j+1] != null &&
//                        ProductBusiness.products[j].getInterest() > ProductBusiness.products[j+1].getInterest()) {
//                    // Swap products
//                    Product temp = ProductBusiness.products[j];
//                    ProductBusiness.products[j] = ProductBusiness.products[j+1];
//                    ProductBusiness.products[j+1] = temp;
//                }
//            }
//        }
//
//        System.out.println("Đã sắp xếp các sản phẩm theo lợi nhuận tăng dần:");
//        displayAllProducts();
//    }

//    private static void deleteBookById() {
//        System.out.print("Nhập mã sách cần xóa: ");
//        int id = InputMethod.inputInteger(scanner);
//
//        boolean found = false;
//        for (int i = 0; i < BookBusiness.books.length; i++) {
//            if (BookBusiness.books[i] != null && BookBusiness.books[i].getBookId() == id) {
//                for (int j = i; j < BookBusiness.books.length - 1; j++) {
//                    BookBusiness.books[j] = BookBusiness.books[j+1];
//                }
//                BookBusiness.books[BookBusiness.books.length - 1] = null;
//                System.out.println("Đã xóa sản phẩm có mã " + id);
//                found = true;
//                break;
//            }
//        }
//
//        if (!found) {
//            System.err.println("Không tìm thấy sách có mã " + id);
//        }
//    }

    private static void searchProductByName() {
        System.out.print("Nhập tên sách cần tìm: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Book book : BookBusiness.books) {
            if (book != null && book.getBookTitle().toLowerCase().contains(name.toLowerCase())) {
                book.displayData();
                found = true;
            }
        }

        if (!found) {
            System.err.println("Không tìm thấy sách có tên: " + name);
        }
    }

//    private static void changeProductStatus() {
//        System.out.print("Nhập mã sách cần thay đổi trạng thái: ");
//        int id = InputMethod.inputInteger(scanner);
//
//        boolean found = false;
//        for (Product product : ProductBusiness.products) {
//            if (product != null && product.getId() == id) {
//                // Toggle status
//                product.setStatus(!product.isStatus());
//                System.out.println("Đã thay đổi trạng thái sách có mã " + id);
//                found = true;
//                break;
//            }
//        }
//
//        if (!found) {
//            System.err.println("Không tìm thấy sách có mã " + id);
//        }
//    }

//    private static int findEmptyProductIndex() {
//        for (int i = 0; i < ProductBusiness.products.length; i++) {
//            if (ProductBusiness.products[i] == null) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
