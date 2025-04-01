package ra.validate;

import java.util.Scanner;

public class InputMethod {
    public static final String ERROR_INTEGER="dữ liệu không phải số nguyên, nhập lại";
    public static final String ERROR_EMPTY_STRING = "Chuỗi không được để trống";
    public static final String ERROR_NUM="dự liệu không phải số, nhập lại";
    public static String inputString(Scanner sc, String title, String errorEmptyString){
        System.out.println(title);
        while(true){
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println(ERROR_EMPTY_STRING);
            } else {
                return input;
            }
        }
    }
    public static int inputInteger(Scanner sc){
        while (true) {
            try {
                System.out.print("Nhập mã sách: ");
                String input = sc.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.err.println(ERROR_INTEGER);
            }
        }
    }
    public static double inputDouble(Scanner sc, String title){
        while (true) {
            try {
                System.out.print(title);
                String input = sc.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.err.println("Dữ liệu không phải số, vui lòng nhập lại");
            }
        }
    }
}
