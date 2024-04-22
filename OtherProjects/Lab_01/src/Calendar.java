import java.util.Scanner;
import java.util.HashMap;

public class Calendar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//      Tạo hash map (months) để lưu trữ các tháng trong năm dưới dạng chuỗi và số tương ứng
        HashMap<String, Integer> months = new HashMap<>();
        months.put("january", 1);
        months.put("jan.", 1);
        months.put("jan", 1);
        months.put("1", 1);

        months.put("february", 2);
        months.put("feb.", 2);
        months.put("feb", 2);
        months.put("2", 2);

        months.put("march", 3);
        months.put("mar.", 3);
        months.put("mar", 3);
        months.put("3", 3);

        months.put("april", 4);
        months.put("apr.", 4);
        months.put("apr", 4);
        months.put("4", 4);

        months.put("may", 5);
        months.put("5", 5);

        months.put("june", 6);
        months.put("jun.", 6);
        months.put("jun", 6);
        months.put("6", 6);

        months.put("july", 7);
        months.put("jul.", 7);
        months.put("jul", 7);
        months.put("7", 7);

        months.put("august", 8);
        months.put("aug.", 8);
        months.put("aug", 8);
        months.put("8", 8);

        months.put("september", 9);
        months.put("sep.", 9);
        months.put("sep", 9);
        months.put("9", 9);

        months.put("october", 10);
        months.put("oct.", 10);
        months.put("oct", 10);
        months.put("10", 10);

        months.put("november", 11);
        months.put("nov.", 11);
        months.put("nov", 11);
        months.put("11", 11);

        months.put("december", 12);
        months.put("dec.", 12);
        months.put("dec", 12);
        months.put("12", 12);

        while (true) {
//        	Người dùng nhập vào tháng, nếu nhập sai (không có trong hash map) thì nhập lại
            System.out.println("Enter month: ");
            String monthInput = scanner.nextLine().toLowerCase();
            if (!months.containsKey(monthInput)) {
                System.out.println("Invalid month. Please enter again.");
                continue;
            }
            int month = months.get(monthInput);

//          Tương tự như tháng, nhập năm -> In ra kết quả
            System.out.println("Enter year: ");
            String yearInput = scanner.nextLine();
            if (!yearInput.matches("\\d+") || yearInput.length() != 4) {
                System.out.println("Invalid year. Please enter again.");
                continue;
            }
            int year = Integer.parseInt(yearInput);

            int days = getDaysOfMonth(month, year);
            System.out.println("Number of days in " + monthInput + " of " + year + ": " + days);
            break;
        }
    }

//  Hàm trả về số ngày trong 1 tháng cụ thể của 1 năm cụ thể, xử lý trường hợp tháng 2 trong năm nhuận và không nhuận
    public static int getDaysOfMonth(int month, int year) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

//  Kiểm tra năm nhuận
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }
}
