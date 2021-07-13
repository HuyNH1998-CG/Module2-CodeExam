import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);
    private static Contact contact = new Contact();
    private static final int show = 1;
    private static final int add = 2;
    private static final int edit = 3;
    private static final int delete = 4;
    private static final int search = 5;
    private static final int readfile = 6;
    private static final int writefile = 7;
    private static final int exit = 8;

    public static void menu() {
        while (true) {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1.Xem danh sách");
            System.out.println("2.Thêm mới");
            System.out.println("3.Cập nhật");
            System.out.println("4.Xóa");
            System.out.println("5.Tìm kiếm");
            System.out.println("6.Đọc từ file");
            System.out.println("7.Ghi vào file");
            System.out.println("8.Thoát");
            System.out.println("Chọn chức năng");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case show -> contact.show();
                case add -> contact.addNew();
                case edit -> contact.edit();
                case delete -> contact.deleteContact();
                case search -> contact.searchContact();
                case readfile -> contact.readContact();
                case writefile -> contact.saveContact();
                case exit -> System.exit(0);
            }
        }
    }
}
